package dao;

/**
 * 数据访问对象（DAO）的实现类，模拟「使用 MySQL 存取数据」的实现方式。
 *
 * 之所以叫 ImplForMysql，是因为实际项目中同一套 DAO 接口可能有多种实现：
 * 例如 UserDaoImplForMysql、UserDaoImplForOracle……
 * 好处是：以后换数据库时，只需在 spring.xml 里把 <bean> 的 class 换成另一个实现类，
 * 业务代码完全不用改 —— 这就是 Spring 带来的「解耦」。
 *
 * 同样通过 spring.xml 中的 <bean class="dao.UserDaoImplForMysql" id="userDaoBean"/> 注册进容器。
 */
public class UserDaoImplForMysql {

    // 无参构造方法。容器创建 userDaoBean 时调用，打印 "保存用户信息" 用来观察对象是否被创建。
    // 说明：实际项目中构造方法一般不做业务操作，这里只是为了演示 Bean 生命周期的「实例化」阶段。
    public UserDaoImplForMysql(){
        System.out.println("保存用户信息");
    }
}
