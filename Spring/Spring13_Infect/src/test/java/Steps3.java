import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import Steps3.Steps3_Config;

public class Steps3 {
    @Test
    public void Action1() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Steps3_Config.class);
//        applicationContext.getBean("")
    }
}
