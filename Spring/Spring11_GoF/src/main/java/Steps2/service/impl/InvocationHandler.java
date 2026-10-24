package Steps2.service.impl;


import java.lang.reflect.Method;

public class InvocationHandler implements java.lang.reflect.InvocationHandler {
    //目标对象
    private Object target;

    //赋值成员变量
    public InvocationHandler(Object target) {
        this.target = target;
    }

    /*
        1. 为什么强行要求你必须实现InvocationHandler接口?
        因为一个类实现接口就必须实现接口中的方法。
        以下这个方法必须是invoke(),因为JDK在底层调用invoke()方法的程序已经提前写好了。
        注意:invoke方法不是我们程序员负责调用的,是JDK负责调用的。
        2. invoke方法什么时候被调用呢?
        当代理对象调用代理方法的时候,注册在InvocationHandler调用处理器当中的invoke()方法被调用。
        3. invoke方法的三个参数:
        invoke方法是JDK负责调用的,所以JDK调用这个方法的时候会自动给我们传过来这三个参数。
        我们可以在invoke方法的大括号中直接使用。
        第一个参数:Object proxy 代理对象的引用。这个参数使用较少。
        第二个参数:Method method 目标对象上的目标方法。(要执行的目标方法就是它。)
        第三个参数:Object[] args 目标方法上的实参。
        */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //写增强代码
        System.out.println("invoke");
        //调用没目标方法
        Object invoke = method.invoke(target, args);
        System.out.println(invoke);
        return null;
    }
}
