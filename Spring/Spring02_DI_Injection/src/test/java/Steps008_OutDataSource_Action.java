import jdbc.DataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Steps008_OutDataSource_Action {
    @Test
    public void Steps008_OutDataSource_Action() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Steps008_OutDataSource.xml");
        Object dataSourceBean = applicationContext.getBean("DataSource_Bean", DataSource.class);
        System.out.println(dataSourceBean);
    }
}
