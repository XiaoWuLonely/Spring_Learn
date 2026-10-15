import bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.CustomerService;
import services.UserService;

public class Spring001ImpTest {
    @Test
    public void UserServiceAction() {
//spring1_set
        ApplicationContext applicationContextForSpring1Set = new ClassPathXmlApplicationContext("spring1_set.xml");
        UserService userService = applicationContextForSpring1Set.getBean("userServiceBean", UserService.class);
        userService.saveUser();

    }

    @Test
    public void CustomerServiceAction() {
        //spring2_constructor
        ApplicationContext applicationContextForSpring2Constructor = new ClassPathXmlApplicationContext("spring2_constructor.xml");
        CustomerService customerService = applicationContextForSpring2Constructor.getBean("customerServiceBean", CustomerService.class);
        customerService.save();
    }

    @Test
    public void CustomerServiceEasyAction() {
        //spring2_constructor(简单类型)
        ApplicationContext applicationContextForSpring2Constructor = new ClassPathXmlApplicationContext("spring2_constructor.xml");
        User user = applicationContextForSpring2Constructor.getBean("userBean", User.class);
        System.out.println(user);
    }
}
