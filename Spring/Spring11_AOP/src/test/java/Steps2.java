import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import Steps2.Steps2_SpringConfig;
import Steps2.Steps2_Service;

public class Steps2 {
    @Test
    public void Action1() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Steps2_SpringConfig.class);
        Steps2_Service steps2Service = applicationContext.getBean("steps2_Service", Steps2_Service.class);
        steps2Service.insert();

    }
}
