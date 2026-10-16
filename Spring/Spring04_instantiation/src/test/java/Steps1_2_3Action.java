import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Steps1_2_3Action {
    @Test
    public void Steps1_Action() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Steps1_2_3.xml");
//        Steps1_SpringBean sb1 = applicationContext.getBean("Steps1_Bean", Steps1_SpringBean.class);
//        Steps2_Start sb2 = applicationContext.getBean("Steps2_Bean", Steps2_Start.class);
        Steps3_Gun sb3 = applicationContext.getBean("Steps3_Factory_Bean", Steps3_Gun.class);

    }

}
