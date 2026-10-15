import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.CustomerService;

public class Steps007_AutoWare_Bytype_Action {
    @Test
    public void Steps007_AutoWare_Bytype_Action() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Steps007_AutoWare_Bytype.xml");
        CustomerService serviceCustomerBean = applicationContext.getBean("Service_Customer_Bean", CustomerService.class);
        serviceCustomerBean.save();
    }
}
