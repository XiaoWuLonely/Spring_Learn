import Steps2.pojo.Steps2_Account;
import Steps2.service.Steps2_AccountService;
import Steps2.service.impl.Steps2_IsolationService1;
import Steps2.service.impl.Steps2_IsolationService2;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Steps2 {
    @Test
    public void Action1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Steps2.xml");
        Steps2_AccountService steps2AccountService = applicationContext.getBean("steps2_AccountServiceImpl", Steps2_AccountService.class);
        try {
            steps2AccountService.save("act-003",2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Action2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Steps2.xml");
        Steps2_IsolationService1 steps2IsolationService1 = applicationContext.getBean("steps2_IsolationService1", Steps2_IsolationService1.class);
        steps2IsolationService1.getByActno("act-003");
    }

    @Test
    public void Action3() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Steps2.xml");
        Steps2_IsolationService2 steps2IsolationService2 = applicationContext.getBean("steps2_IsolationService2", Steps2_IsolationService2.class);
        Steps2_Account steps2Account = new Steps2_Account("act-003", 5000);
        try {
            steps2IsolationService2.save(steps2Account);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
