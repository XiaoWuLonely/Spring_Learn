import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import steps9.Spring9Config;
import steps9.service.Steps9_StudentService;

public class Steps9_Action {
    @Test
    public void Test1() {
        //不需要Spring配置文件，但需要设置一个配置类
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Spring9Config.class);
        Steps9_StudentService steps9StudentService = applicationContext.getBean("steps9_StudentService", Steps9_StudentService.class);
        steps9StudentService.deleteStudent();
    }
}
