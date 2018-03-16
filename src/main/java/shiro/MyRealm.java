package shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

public class MyRealm implements Realm{

    @Override
    public String getName() {
        return "myRealm";
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
       String name=(String) token.getPrincipal();
       String psw=new String((char[])token.getCredentials());
       if (!"zhang".equals(name)){
           throw  new UnknownAccountException();
       }
       if (!"123".equals(psw)){
           throw  new IncorrectCredentialsException();
       }
       return new SimpleAuthenticationInfo(name,psw,getName());
    }
}
