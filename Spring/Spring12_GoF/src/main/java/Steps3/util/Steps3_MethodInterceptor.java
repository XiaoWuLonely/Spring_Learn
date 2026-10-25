package Steps3.util;

import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Steps3_MethodInterceptor implements net.sf.cglib.proxy.MethodInterceptor {


    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        long begin = System.currentTimeMillis();


        Object retValue = proxy.invokeSuper(obj, args);
        long end = System.currentTimeMillis();
        System.out.println(end - begin + ":ms");
        return retValue;
    }
}
