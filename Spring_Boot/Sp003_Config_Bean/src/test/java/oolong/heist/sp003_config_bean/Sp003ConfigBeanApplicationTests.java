package oolong.heist.sp003_config_bean;

import oolong.heist.sp003_config_bean.bean.AppBean;
import oolong.heist.sp003_config_bean.bean.MyAddress;
import oolong.heist.sp003_config_bean.bean.User;
import oolong.heist.sp003_config_bean.config.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Sp003ConfigBeanApplicationTests {
    //001#config
    @Autowired
    private AppConfig config;

    @Test
    void test1() {
        System.out.println(config.toString());
    }

    //002#bean
    @Autowired
    private User user;

    @Test
    void test2() {
        System.out.println(user.toString());
    }


    //003#bean\AppBean
    @Autowired
    private AppBean appBean;

    @Test
    void test3() {
        System.out.println(appBean.toString());
    }


    //oolong.heist.sp003_config_bean.config.AppConfig2
    @Autowired
    private MyAddress address;

    @Test
    void test4(){
        System.out.println(address.toString());
    }
}
