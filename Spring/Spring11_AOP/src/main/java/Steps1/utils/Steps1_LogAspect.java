package Steps1.utils;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class Steps1_LogAspect {
    @Pointcut("execution(* Steps1.service..*(..))")
    public void 通用(){}

    // 切面=通知 + 切点
    // 通知就是增强,就是具体的要编写的增强代码
    // 这里通知Advice以方法的形式出现。(因为方法中可以写代码)
    //@Before注解标注的方法就是一个前置通知。
    //@Before("execution(* Steps1.service.Steps1_UserService.login(..))")
    //@Before("execution(* Steps1.service.Steps1_UserService.*(..))")
    @Before("通用()")
    public void add(JoinPoint joinPoint) {
        System.out.println("疯狂水世界启动(前置)");
        //可以通过JoinPoint joinPoint获得方法签名
        System.out.println(joinPoint.getSignature().getName());
    }

    //后置
    @AfterReturning("通用()")
    public void after() {
        System.out.println("打捞海水过滤器(后置)");
    }
    //环绕
    @Around("通用()")
    public void arround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("front（环绕前）");
        joinPoint.proceed();//执行目标
        System.out.println("back(环绕后)");
    }

    //最终
    @After("通用()")
    public void TFinal(){
        System.out.println("最终");
    }

    //异常
    @AfterThrowing("通用()")
    public void afterThrowing() {
        System.out.println("异常");
    }
}
