package business.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class LogAspect {

    //声明一个切点
    @Pointcut("@annotation(business.aop.Action)")
//    @Pointcut("execution(* business.controller.*.*(..))")
    public void myPointCut() {
    }


    //指定切入点表达式，拦截那些方法，即为那些类生成代理对象
    //@Pointcut("execution(* com.bie.aop.UserDao.save(..))")  ..代表所有参数
    //@Pointcut("execution(* com.bie.aop.UserDao.*())")  指定所有的方法
    //@Pointcut("execution(* com.bie.aop.UserDao.save())") 指定save方法
//    @Before("execution(* business.controller.*.*(..))")   //代表controller包下面的所有方法，所有参数
    @Before("myPointCut()")
    public void before(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action=method.getAnnotation(Action.class);
        System.out.println("  before -----  "+action.desc());
    }

    @After("myPointCut")
    public void after(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action=method.getAnnotation(Action.class);
        System.out.println(" after ------  "+action.desc());
    }
}
