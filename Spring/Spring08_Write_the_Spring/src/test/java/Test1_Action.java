import com.myspringframework.core.ApplicationContext;
import com.myspringframework.core.ClassPathXmlAplicationContext;
import com.powernode.myspring.bean.Steps1_User_Service;
import org.junit.Test;

public class Test1_Action {
    @Test
    public void Test1_ClassPathXmlApplicationContext() {
        ApplicationContext applicationContext = new ClassPathXmlAplicationContext("mysspriong.xml");
        Object userBean = applicationContext.getBean("User_Bean");
        System.out.println(userBean);

        Object daoBean = applicationContext.getBean("Dao_Bean");
        System.out.println(daoBean);

        Steps1_User_Service serviceBean = (Steps1_User_Service) applicationContext.getBean("Service_Bean");
        serviceBean.save();

    }
}
