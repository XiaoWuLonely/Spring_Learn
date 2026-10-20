import annotation.Component;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReflectAnnotationTest1 {
    @Test
    public void Test1() throws Exception {
        Class<?> aClass = Class.forName("bean.Steps1_User");
        if (aClass.isAnnotationPresent(Component.class)) {
            Component annotation = aClass.getAnnotation(Component.class);
            System.out.println(annotation.value());
        }
    }

    @Test
    public void Test2() {
        Map<String, Object> beanMap = new HashMap<>();
        // 目前只知道一个包的名字,扫描这个包下所有的类,当这个类上有@Component注解的时候,实例化该对象,然后放到Map集合中。
        String packageName = "bean";
        // 开始写扫描程序。
        //. 这个正则表达式代表任意字符。这里的”,“必须是一个普通的”,“字符。不能是正则表达式中的”。”
        // 在正则表达式当中怎么表示一个普通的”。“字符呢?使用\.正则表达式代表一个普通的. 字符。
        packageName.replaceAll("\\.", "/");

        // 第三步：使用系统类加载器，从 Classpath（类路径，通常指 target/classes）下寻找这个资源，返回一个 URL 对象
        URL url = ClassLoader.getSystemClassLoader().getResource(packageName);

        // 第四步：从 URL 对象中提取出物理路径（字符串格式）
        String path = url.getPath();

        // 第五步：根据拿到的路径字符串，在硬盘上创建一个 File 对象（代表这个文件夹）
        File file = new File(path);
        // 第六步：获取这个文件夹下的所有文件（包括 .class 文件或子文件夹），返回一个 File 数组
        File[] files = file.listFiles();

        // 第七步：使用 Java 8 的 Stream API 遍历这个数组，并打印出每个文件的名称
        Arrays.stream(files).forEach(f -> {
            try {
                String ClassName = packageName +"."+ f.getName().split("\\.")[0];
                Class<?> aClass = Class.forName(ClassName);
                if (aClass.isAnnotationPresent(Component.class)) {
                    Component annotation = aClass.getAnnotation(Component.class);
                    String id = annotation.value();
                    Object o = aClass.newInstance();
                    beanMap.put(id, o);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        System.out.println(beanMap);

    }
}