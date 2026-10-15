import bean.Steps4_Set_Array;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring04_Set_Array {
    @Test
    public void Spring04_Set_Array_Action() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring04_Set_Array.xml");
        Steps4_Set_Array steps4_set_array = applicationContext.getBean("Spring04_Set_Array_Bean", Steps4_Set_Array.class);
        System.out.println(steps4_set_array);
    }

}
