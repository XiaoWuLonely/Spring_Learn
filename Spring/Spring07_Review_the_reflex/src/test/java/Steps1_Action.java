import org.junit.Test;

import java.lang.reflect.Method;

public class Steps1_Action {
    @Test
    public void Test1() {
        Steps1_Reflex someService = new Steps1_Reflex();

        someService.doSome();

        /**
         * 分析:调用一个方法,当中含有几个要素?四要素。
         * 第一要素:调用哪个对象
         * 第二要素:调用哪个方法
         * 第三要素:调用方法的时候传什么参数
         * 第四要素:方法执行结束之后的返回结果
         */
        String s1 = someService.doSome("藏三");
        System.out.println(s1);
        String s2 = someService.doSome("李四", 5);
        System.out.println(s2);
    }

    @Test
    public void Test2() throws Exception {
//       使用反射机制怎么调用方法
        //获取类
        Class<?> clazz = Class.forName("Steps1_Reflex");

        //获取方法
        Method doSome = clazz.getDeclaredMethod("doSome", String.class, int.class);

        //调用方法
        //四要素，调用哪个对象、方法。传什么参数、返回什么值
        Object o = clazz.newInstance();
        Object retValue = doSome.invoke(o, "李四", 21);
        System.out.println(retValue);
    }


    @Test
    public void Test3() throws Exception {
        Class<?> clazz = Class.forName("Steps1_Reflex");
        Method doSomeMethod = clazz.getDeclaredMethod("doSome");

        Object obj = clazz.newInstance();
        doSomeMethod.invoke(obj);
    }
}
