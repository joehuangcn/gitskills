import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class testHelloWord {

    @Test
    public void Hello(){

        //获取工厂
//        Factory <SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro.ini");
//        Factory <SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro-my.ini");
        Factory <SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro-jdbc-realm.ini");
        //等到sercurityManager 实例
        SecurityManager securityManager=factory.getInstance();
        //绑定给Utils
        SecurityUtils.setSecurityManager(securityManager);
        //得到用户名token
        Subject subject=SecurityUtils.getSubject();

       UsernamePasswordToken usernamePasswordToken= new UsernamePasswordToken("zhang","123");

        subject.login(usernamePasswordToken);
        Assert.assertEquals(true,subject.isAuthenticated());
        subject.logout();
    }

    private void login(String configFile,String username,String psw){
        Factory<SecurityManager> factory=new IniSecurityManagerFactory(configFile);
        SecurityManager securityManager=factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        Subject subject=SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(username,psw);
        subject.login(token);

    }

    @Test
    public void testOk(){
        login("classpath:shiro/shiro-jdbc-realm-allSuccess.ini","zhang","123");
        Subject subject=SecurityUtils.getSubject();
        PrincipalCollection collection=subject.getPrincipals();
        Assert.assertEquals(2,collection.asList().size());
    }

    @Test
    public void testRole(){
        login("classpath:shiro/shiro-role.ini","zhang","123");
        Subject subject=SecurityUtils.getSubject();
        Assert.assertTrue(subject.hasRole("master"));
        boolean [] result=subject.hasRoles(Arrays.asList("master","admin","teacher"));
        Assert.assertEquals(true,result[0]);
        Assert.assertEquals(false,result[1]);
        Assert.assertEquals(false,result[2]);

    }
}
