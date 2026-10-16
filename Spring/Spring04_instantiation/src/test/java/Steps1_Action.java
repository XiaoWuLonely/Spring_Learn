import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Steps1_Action {
    @Test
    public void Steps1_Action() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Steps1_Spring.xml");
        Steps1_SpringBean sb = applicationContext.getBean("Steps1_Bean", Steps1_SpringBean.class);
    }

}
