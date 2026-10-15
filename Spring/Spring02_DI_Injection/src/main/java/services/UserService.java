package services;

import dao.UserDao;
import dao.VipDao;

public class UserService {
    private UserDao userDao;
    private VipDao vipDao;

    // Set注入（注意这里的命名规则为小写set开头）
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    // Set注入
    public void setVipDao(VipDao vipDao) {
        this.vipDao = vipDao;
    }

    //实例方法
    public void saveUser() {
        userDao.insert();
        vipDao.insert();
    }
}
