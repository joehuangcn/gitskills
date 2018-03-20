package demo1.realm;

import demo1.dao.UserRepo;
import demo1.service.UserService;
import demo1.service.impl.UserServiceImpl;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import demo1.entity.*;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserRepo userRepo;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username=(String) authenticationToken.getPrincipal();
        String pwd=new String( (char[]) authenticationToken.getCredentials());
            User user= userRepo.findByUsername(username);
            if (user==null){
                throw  new UnknownAccountException();
            }
            if (Boolean.TRUE.equals(user.getLocked()))
                throw  new LockedAccountException();
            return new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),
                    ByteSource.Util.bytes(user.getSalt()),getName());
    }
}
