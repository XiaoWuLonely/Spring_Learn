import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import steps7.service.Steps7_OrderService;
import steps8.service.Steps8_StudentService;

public class Steps8_Action {
    @Test
    public void Test1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Steps8.xml");
        Steps8_StudentService steps8StudentService = applicationContext.getBean("steps8_StudentService", Steps8_StudentService.class);
        steps8StudentService.deleteStudent();
    }
}
