package Steps2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Steps2_LogAspect {
    @Pointcut("execution(* Steps2..*(..))")
    public void 通用(){}
    @Before("通用()")
    public void add(JoinPoint joinPoint) {
        System.out.println("疯狂水世界启动(前置)");
        //可以通过JoinPoint joinPoint获得方法签名
        System.out.println(joinPoint.getSignature().getName());
    }
}
