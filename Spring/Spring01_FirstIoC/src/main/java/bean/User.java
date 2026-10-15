package bean;

/**
 * 一个普通的 Java 类（POJO），本身没有依赖任何 Spring 的东西。
 *
 * Spring 的核心思想是 IoC（控制反转）：
 * 对象不由我们自己 new 出来，而是交给 Spring 容器去创建和管理，
 * 这样的对象就叫 Bean。
 *
 * 这个类被注册成了两个 Bean：
 *   - spring.xml 中 id="userBean"
 *   - bean.xml   中 id="Bean2"
 * 这说明「同一个类可以被注册成多个不同 id 的 Bean」。
 *
 * 注意：Spring 默认通过「无参构造方法」创建 Bean，所以必须保证有无参构造。
 */
public class User {

    // 无参构造方法。容器创建 User 类型的 Bean 时会调用它，
    // 控制台打印 "hello" 就能证明：对象确实是 Spring 帮我们创建的。
    public User(){
        System.out.println("hello");
    }

    // 模拟一个业务方法。从容器拿到 User 对象后可以直接调用它，
    // 演示「Bean 不只是被创建，还能正常使用其方法」。
    public void insert(){
        System.out.println("insert Methods");
    }
}
