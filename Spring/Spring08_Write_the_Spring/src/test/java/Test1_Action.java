import com.myspringframework.core.ApplicationContext;
import com.myspringframework.core.ClassPathXmlAplicationContext;
import org.junit.Test;

public class Test1_Action {
    @Test
    public void Test1_ClassPathXmlApplicationContext() {
        ApplicationContext applicationContext = new ClassPathXmlAplicationContext("mysspriong.xml");
    }
}
