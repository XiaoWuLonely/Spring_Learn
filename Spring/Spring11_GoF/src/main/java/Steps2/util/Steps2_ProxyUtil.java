package Steps2.util;

import Steps2.impl.InvocationHandler;

import java.lang.reflect.Proxy;

public class Steps2_ProxyUtil {

    //封装工具方法
    public static Object newProxyInstance(Object target) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler(target));

    }
}
