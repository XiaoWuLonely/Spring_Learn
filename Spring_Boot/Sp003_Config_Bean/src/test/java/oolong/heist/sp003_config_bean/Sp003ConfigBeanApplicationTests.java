package oolong.heist.sp003_config_bean;

import oolong.heist.sp003_config_bean.config.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Sp003ConfigBeanApplicationTests {
    @Autowired
    private AppConfig config;

    @Test
    void test1() {
        System.out.println(config.toString());
    }

}
