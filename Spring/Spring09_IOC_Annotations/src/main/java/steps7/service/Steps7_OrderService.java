package steps7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import steps7.Dao.Steps7_OrderDao;

@Service
public class Steps7_OrderService {

    //@Autowired注解使用的时候,不需要指定任何属性,直接使用这个注解即可。
    // 这个注解的作用是根据类型byType进行自动装配。
    //@Autowired
    //private Steps7_OrderDao steps7_orderDao;

    //如果多个实现方法继承了同一个对象就会报错，因为它不知道注入哪个
    //无法自动装配。存在多个 'Steps7_OrderDao' 类型的 Bean。
    //Beans:
    //steps7_OrderDaoImpl   (Steps7_OrderDaoImpl.java)
    //steps7_OrderDaoImplByOracle   (Steps7_OrderDaoImplByOracle.java)
    // 如果想解决以上问题,只能根据名字进行装配。
    //@Autowired和@Qualifier联合使用,可以根据名字进行装配。

    @Autowired
    @Qualifier("steps7_OrderDaoImplByOracle")
    private Steps7_OrderDao steps7_orderDao;


    public void generate() {
        steps7_orderDao.insert();
    }
}
