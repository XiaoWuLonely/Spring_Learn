package Steps1.utils;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class Steps1_Security {
    @Before("Steps1.utils.Steps1_LogAspect.通用()")
    public void beforeAdive(){
        System.out.println("前置通知：安全");
    }
}
