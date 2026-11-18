package oolong.heist.sp003_config_bean.config;

import oolong.heist.sp003_config_bean.bean.MyAddress;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 指定该类是一个配置类。
@Configuration
public class AppConfig2 {

    // 假设Address是第三方库提供的类。我们使用以下方式可以完成配置到bean的属性的绑定。
    @Bean//纳入IoC容器的管理
    @ConfigurationProperties(prefix = "other.abc")//将配置文件中凡是以 other.abc 开头的配置数据绑定到Address对象的属性上。
    public MyAddress address() {
        return new MyAddress();
    }
}
