import Steps2.Steps2_Husban;
import Steps2.Steps2_Wife;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Steps2_Action {
    @Test
    public void  Steps2_Action() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Steps2_Beans.xml");
        Steps2_Husban steps2HusbanBean = applicationContext.getBean("Steps2_Husban_Bean", Steps2_Husban.class);
        System.out.println(steps2HusbanBean);

        Steps2_Wife steps2WifeBean = applicationContext.getBean("Steps2_Wife_Bean", Steps2_Wife.class);
        System.out.println(steps2WifeBean);
    }
}
