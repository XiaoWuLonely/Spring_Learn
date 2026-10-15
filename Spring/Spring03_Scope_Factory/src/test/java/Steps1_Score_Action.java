import Bean.Steps1_Bean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Steps1_Score_Action {
    @Test
    public void Steps1_Score_Action() {
        //singleton
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Steps1_Score.xml");
        Steps1_Bean steps1BeanBean = applicationContext.getBean("Steps1_Bean_Bean", Steps1_Bean.class);
        System.out.println(steps1BeanBean);
        Steps1_Bean steps1BeanBean2 = applicationContext.getBean("Steps1_Bean_Bean", Steps1_Bean.class);
        System.out.println(steps1BeanBean2);
        //threadScope
        new Thread(new Runnable() {
            @Override
            public void run() {
                Steps1_Bean steps1BeanThreadScope = applicationContext.getBean("Steps1_Bean_ThreadScope", Steps1_Bean.class);
                System.out.println(steps1BeanThreadScope);
                Steps1_Bean steps1BeanThreadScope2 = applicationContext.getBean("Steps1_Bean_ThreadScope", Steps1_Bean.class);
                System.out.println(steps1BeanThreadScope2);
            }
        }).start();
    }
}
