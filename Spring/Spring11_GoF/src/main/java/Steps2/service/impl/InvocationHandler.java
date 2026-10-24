package Steps2.service.impl;


import java.lang.reflect.Method;

public class InvocationHandler implements java.lang.reflect.InvocationHandler {

    /*

    1. 为什么强行要求你必须实现InvocationHandler接口?
    因为一个类实现接口就必须实现接口中的方法。
    以下这个方法必须是invoke(),因为JDK在底层调用invoke()方法的程序已经提前写好了。
    注意:invoke方法不是我们程序员负责调用的,是JDK负责调用的。
    2. invoke方法什么时候被调用呢?
    当代理对象调用代理方法的时候,注册在InvocationHandler调用处理器当中的invoke()方法被调用。

    */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //写增强代码
        System.out.println("invoke");
        return null;
    }
}
