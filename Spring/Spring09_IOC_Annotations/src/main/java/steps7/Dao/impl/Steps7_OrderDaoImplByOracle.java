package steps7.Dao.impl;

import org.springframework.stereotype.Repository;
import steps7.Dao.Steps7_OrderDao;



@Repository
public class Steps7_OrderDaoImplByOracle implements Steps7_OrderDao {
    @Override
    public void insert() {
        System.out.println("Steps7_OrderDaoImplByOracle正在保存");
    }
}
