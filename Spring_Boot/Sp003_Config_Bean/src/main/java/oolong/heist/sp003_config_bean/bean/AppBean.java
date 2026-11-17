package oolong.heist.sp003_config_bean.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "app2.abc")
public class AppBean {
    // 数组:数组中元素是简单类型
    private String[] names;
    //数组:数组中元素是bean
    private MyAddress[] addrArray;
    // List集合:集合中的元素是bean
    private List<MyAddress> addrList;
    // Map集合:String,Bean
    private Map<String, MyAddress> addrs;

    @Override
    public String toString() {
        return "AppBean{" +
                "names=" + Arrays.toString(names) +
                ", addrArray=" + Arrays.toString(addrArray) +
                ", addrList=" + addrList +
                ", addrs=" + addrs +
                '}';
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    public void setAddrArray(MyAddress[] addrArray) {
        this.addrArray = addrArray;
    }

    public void setAddrList(List<MyAddress> addrList) {
        this.addrList = addrList;
    }

    public void setAddrs(Map<String, MyAddress> addrs) {
        this.addrs = addrs;
    }
}