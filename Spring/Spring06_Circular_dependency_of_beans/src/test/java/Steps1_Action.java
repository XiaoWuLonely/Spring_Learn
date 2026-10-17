import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Steps1_Action {
    @Test
    public void Steps1_Action() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Steps1_Beans.xml");
        Steps1_Husban steps1HusbanBean = applicationContext.getBean("Steps1_Husban_Bean", Steps1_Husban.class);
        System.out.println(steps1HusbanBean);
        Steps1_Wife steps1WifeBean = applicationContext.getBean("Steps1_Wife_Bean", Steps1_Wife.class);
        System.out.println(steps1WifeBean);
    }


}
