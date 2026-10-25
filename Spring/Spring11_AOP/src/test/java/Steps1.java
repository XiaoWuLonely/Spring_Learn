import Steps1.service.Steps1_UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Steps1 {
    @Test
    public void Test1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Steps1.xml");
        Steps1_UserService steps1UserService = applicationContext.getBean("steps1_UserService", Steps1_UserService.class);
        steps1UserService.login();
    }
}
