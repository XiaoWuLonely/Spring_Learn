import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Steps1_Action {
    @Test
    public void Steps1_Action() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Steps1_Bean.xml");
        Steps1_User steps1Bean = applicationContext.getBean("Steps1_Bean", Steps1_User.class);
        System.out.println("Forth:使用Bean" + steps1Bean);
        // 注意:必须手动关闭Spring容器,这样Spring容器才会销毁Bean.
        ClassPathXmlApplicationContext context = (ClassPathXmlApplicationContext) applicationContext;
        context.close();
    }

}
