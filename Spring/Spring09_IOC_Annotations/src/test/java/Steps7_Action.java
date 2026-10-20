import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import steps6Bean.Steps6_MyDataSource;
import steps7.service.Steps7_OrderService;

public class Steps7_Action {
    @Test
    public void Test1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Steps7.xml");
        Steps7_OrderService steps7_orderService = applicationContext.getBean("steps7_OrderService", Steps7_OrderService.class);
        steps7_orderService.generate();
    }
}
