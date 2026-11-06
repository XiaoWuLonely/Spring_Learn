package oolong.heist.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

// 使用这个也是可以的。因为这样也可以纳入IoC容器的管理,同时表示是一个配置类
@Configuration
// 纳入IoC容器的管理
//@Components
public class AppConfig {

    @Value("${myapp.path}")
    private String appPath;

    public void printInfo(){
        System.out.println(appPath);
    }
}
