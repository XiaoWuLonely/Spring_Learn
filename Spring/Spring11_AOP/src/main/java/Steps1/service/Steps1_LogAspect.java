package Steps1.service;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Steps1_LogAspect {
    // 切面=通知 + 切点
    // 通知就是增强,就是具体的要编写的增强代码
    // 这里通知Advice以方法的形式出现。(因为方法中可以写代码)
    //@Before注解标注的方法就是一个前置通知。
    //@Before("execution(* Steps1.service.Steps1_UserService.login(..))")
    //@Before("execution(* Steps1.service.Steps1_UserService.*(..))")
    @Before("execution(* Steps1.service..*(..))")
    public void add() {
        System.out.println("疯狂水世界启动(前置)");
    }

    //后置
    @AfterReturning("execution(* Steps1.service..*(..))")
    public void after() {
        System.out.println("打捞海水过滤器(后置)");
    }
    //环绕
    @Around("execution(* Steps1.service..*(..))")
    public void arround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("front（环绕前）");
        joinPoint.proceed();//执行目标
        System.out.println("back(环绕后)");
    }

    //最终
    @After("execution(* Steps1.service..*(..))")
    public void TFinal(){
        System.out.println("最终");
    }

    //异常
    @AfterThrowing("execution(* Steps1.service..*(..))")
    public void afterThrowing() {
        System.out.println("异常");
    }
}
