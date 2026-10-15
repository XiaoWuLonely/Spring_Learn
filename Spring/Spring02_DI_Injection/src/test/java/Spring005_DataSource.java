import jdbc.Steps5_MyDataSource1;
import jdbc.Steps5_MyDataSource2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring005_DataSource {
    @Test
    public void UtilDataSource(){
        ApplicationContext applicationContext  = new ClassPathXmlApplicationContext("Spring05_DataSource.xml");
        Object ds1 = applicationContext.getBean("ds1", Steps5_MyDataSource1.class);
        System.out.println(ds1);
        Object ds2 = applicationContext.getBean("ds2", Steps5_MyDataSource2.class);
        System.out.println(ds2);
    }
}
