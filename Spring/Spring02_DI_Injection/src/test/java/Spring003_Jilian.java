import bean.Steps3_Jilian_Class;
import bean.Steps3_Jilian_Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring003_Jilian {
    @Test
    public void JiianAction() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring03_jilian.xml");
        Steps3_Jilian_Student studentBean = applicationContext.getBean("studentBean", Steps3_Jilian_Student.class);
        System.out.println(studentBean);
        Steps3_Jilian_Class classBean = applicationContext.getBean("classBean", Steps3_Jilian_Class.class);
        System.out.println(classBean);
    }
}
