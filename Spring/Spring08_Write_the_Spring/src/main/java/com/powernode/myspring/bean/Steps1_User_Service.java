package com.powernode.myspring.bean;

public class Steps1_User_Service {
    private Steps1_User_Dao userDao;

    public void setUserDao(Steps1_User_Dao userDao) {
        this.userDao = userDao;
    }

    public void save() {
        userDao.insert();
    }
}
