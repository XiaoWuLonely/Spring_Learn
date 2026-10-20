import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import steps6Bean.Steps6_MyDataSource;

public class Steps6_Action {
    @Test
    public void Test1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Steps6.xml");
        Steps6_MyDataSource steps6MyDataSource = applicationContext.getBean("steps6_MyDataSource", Steps6_MyDataSource.class);
        System.out.println(steps6MyDataSource);
    }
}
