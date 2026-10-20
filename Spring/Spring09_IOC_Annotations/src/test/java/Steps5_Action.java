import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Steps5_Action {
    @Test
    public void Test1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Steps5.xml");
    }
}
