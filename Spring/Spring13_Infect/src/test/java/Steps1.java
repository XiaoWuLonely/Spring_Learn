import Steps1.service.impl.AccountServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Steps1 {
    @Test
    public void Action1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Steps1.xml");
        AccountServiceImpl accountServiceImpl = applicationContext.getBean("accountServiceImpl", AccountServiceImpl.class);
        try {
            accountServiceImpl.transfer("act-001", "act-002", 1);
            System.out.println("转账成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
