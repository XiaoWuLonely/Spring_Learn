import jdbc.DataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring002_jdbc {
    @Test
    public void myDataSource() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring3_jdbc.xml");
        DataSource myDataSource = applicationContext.getBean("myDataSource", DataSource.class);
        System.out.println(myDataSource);
    }

}
