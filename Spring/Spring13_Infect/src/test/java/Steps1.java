import Steps1.service.AccountService;
import Steps1.service.impl.AccountServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Steps1 {
    @Test
    public void Action1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Steps1.xml");
        AccountService accountService = applicationContext.getBean("accountServiceImpl", AccountService.class);
        try {
            accountService.transfer("act-001", "act-002", 1);
            System.out.println("转账成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
