import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.Steps006_AutoWire_Service;

public class Steps006_AutoWire {
    @Test
    public void Steps006_AutoWire_Action(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring006_AutoWire.xml");
        Steps006_AutoWire_Service steps006AutoWireService = applicationContext.getBean("steps006AutoWireService", Steps006_AutoWire_Service.class);
        steps006AutoWireService.generate();
    }
}
