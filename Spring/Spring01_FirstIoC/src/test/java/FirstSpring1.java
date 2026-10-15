import bean.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 第一个 Spring 程序：演示如何启动 IoC 容器并从中获取 Bean。
 * <p>
 * 核心步骤：
 * 1. 创建容器（ClassPathXmlApplicationContext），传入一个或多个 XML 配置文件；
 * 2. 容器启动时会立即解析 XML，并把其中所有的 <bean> 单例对象都创建出来（饿汉式）；
 * 3. 通过 getBean("id") 按 Bean 的 id 从容器中取对象。
 * <p>
 * 本示例额外演示了三点：
 *   - 可以同时加载多个配置文件（spring.xml / bean.xml / util/Date.xml）；
 *   - getBean 有两种用法：按 id 取 Object，或按 id + 类型取对应类型的对象；
 *   - 第三方类（如 java.util.Date）也可以注册成 Bean。
 */
public class FirstSpring1 {

    @Test
    public void testFirstSpringCode() {
        // ===== 第 1 步：启动 IoC 容器 =====
        // - ApplicationContext 是 Spring 容器的顶层接口；
        // - ClassPathXmlApplicationContext 是它的实现类，从「类路径」（src/main/resources）下读取 XML 配置；
        // - 可以同时传入多个配置文件，这里把三个文件里的 Bean 都加载进来。
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring.xml", "bean.xml", "util/Date.xml");

        // ===== 第 2 步：按 id 获取 Bean（返回 Object）=====
        // getBean(String) 只按 id 查找，返回类型是 Object，需要的话自己强转。
        // 注意：第一次执行到这里之前，控制台就已经打印了 "hello" / "保存用户信息"，
        // 说明单例 Bean 在容器启动阶段就被创建好了（饿汉式）。
        Object userBean = applicationContext.getBean("userBean");
        System.out.println(userBean);

        Object userDaoBean = applicationContext.getBean("userDaoBean");
        System.out.println(userDaoBean);

        // ===== 第 3 步：按 id + 类型获取 Bean（返回指定类型）=====
        // getBean(String, Class) 会把 Bean 自动转成指定类型，省去强转；
        // 类型不匹配时会抛出 BeanNotOfRequiredTypeException。
        User userBean2 = applicationContext.getBean("Bean2", User.class);
        System.out.println(userBean2);
        // 拿到 Bean 后可以正常调用它的方法
        userBean2.insert();

        // ===== 第 4 步：第三方类（java.util.Date）作为 Bean =====
        // java.util.Date 不是我们写的类，但照样可以注册成 Bean 来使用。
        Object dateBean = applicationContext.getBean("DateBean");
        System.out.println(dateBean);

        // 同样的 Bean，用带类型的方式取出，再格式化成易读的时间字符串。
        Date dateBeanTyped = applicationContext.getBean("DateBean", Date.class);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String nowTime = sdf.format(dateBeanTyped);
        System.out.println(nowTime);
    }

    @Test
    public void testTwiceSpringCode(){
        new ClassPathXmlApplicationContext("spring.xml","bean.xml","util/Date.xml");

        Logger logger  = LoggerFactory.getLogger(FirstSpring1.class);

        logger.info("消息1");
        logger.debug("消息2");
        logger.error("消息3");
    }
}
