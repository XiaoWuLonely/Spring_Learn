package services;

import dao.UserDao;
import dao.VipDao;

public class CustomerService {
    private UserDao userDao;
    private VipDao vipDao;

    //构造注入
//    public CustomerService(UserDao userDao, VipDao vipDao) {
//        this.userDao = userDao;
//        this.vipDao = vipDao;
//    }

    public void save() {
        userDao.insert();
        vipDao.insert();
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setVipDao(VipDao vipDao) {
        this.vipDao = vipDao;
    }
}
