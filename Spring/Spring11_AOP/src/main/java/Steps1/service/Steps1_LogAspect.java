package Steps1.service;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Steps1_LogAspect {
    // 切面=通知 + 切点
    // 通知就是增强,就是具体的要编写的增强代码
    // 这里通知Advice以方法的形式出现。(因为方法中可以写代码)
    //@Before注解标注的方法就是一个前置通知。
//    @Before("execution(* Steps1.service.Steps1_UserService.login(..))")
//    @Before("execution(* Steps1.service.Steps1_UserService.*(..))")
    @Before("execution(* Steps1.service..*(..))")
    public void add() {
        System.out.println("疯狂水世界启动");
    }
}
