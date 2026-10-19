package com.myspringframework.core;

import java.util.HashMap;
import java.util.Map;

public class ClassPathXmlAplicationContext implements ApplicationContext {
    private Map<String,Object> singletionObject = new HashMap<>();

    /**
     * 解析myspring的配置文件,然后初始化所有的Bean对象。
     *
     * @param configLocation
     **/
    public ClassPathXmlAplicationContext(String configLocation) {
        //解析myspring.xml文件,然后实例化Bean,将Bean存放到singLetonObjects集合当中。
    }

    @Override
    public Object getBean(String beanName) {
        return singletionObject.get(beanName);
    }
}
