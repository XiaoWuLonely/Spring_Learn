import bean.Steps3_Order;
import bean.Steps3_Student;
import bean.Steps3_User;
import bean.Steps3_Vip;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Steps3_Action {
    @Test
    public void Test1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Steps3.xml");
        Steps3_Order orderBean = applicationContext.getBean("OrderBean", Steps3_Order.class);
        Steps3_Student studentBean = applicationContext.getBean("StudentBean", Steps3_Student.class);
        Steps3_User userBean = applicationContext.getBean("userBean", Steps3_User.class);
        //其他几个都可以省区Value，这里拿Service做例子。默认是类名+首字母小写
        Steps3_Vip vipBean = applicationContext.getBean("steps3_Vip", Steps3_Vip.class);
        System.out.println(orderBean);
        System.out.println(studentBean);
        System.out.println(userBean);
        System.out.println(vipBean);
    }
}
