package oolong.heist.sp003_config_bean.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@Component //第一种
//@Configuration //第二种
@ConfigurationProperties(prefix = "app.xyz")
public class User {
    private String name;
    private MyAddress myAddress;

    public void setName(String name) {
        this.name = name;
    }

    public void setMyAddress(MyAddress myAddress) {
        this.myAddress = myAddress;
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", myAddress=" + myAddress + '}';
    }
}
