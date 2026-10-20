import annotation.Component;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.junit.Test;

public class ReflectAnnotationTest1 {
    @Test
    public void Test1() throws Exception {
        Class<?> aClass = Class.forName("bean.Steps1_User");
        if (aClass.isAnnotationPresent(Component.class)) {
            Component annotation = aClass.getAnnotation(Component.class);
            System.out.println(annotation.value());
        }
    }
}