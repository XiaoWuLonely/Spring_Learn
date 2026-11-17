package oolong.heist.sp003_config_bean;

import oolong.heist.sp003_config_bean.bean.AppBean;
import oolong.heist.sp003_config_bean.bean.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

//将配置信息绑定到bean的第三种方式:在主入口程序上添加一下注解。
// 以下注解的作用是:启用将配置信息绑定到bean,以下代码的意思就是将配置信息绑定到User这个bean上。
//@EnableConfigurationProperties(User.class)
@EnableConfigurationProperties({User.class, AppBean.class})
@SpringBootApplication
public class Sp003ConfigBeanApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sp003ConfigBeanApplication.class, args);
    }

}
