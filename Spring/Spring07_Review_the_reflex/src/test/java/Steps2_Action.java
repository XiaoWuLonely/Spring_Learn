import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Steps2_Action {

    @Test
    public void Test1() throws Exception {

        /**
         需求:
         假设你现在已知以下信息:
         1. 有这样一个类,类名叫做:com.powernode.reflect.User
         2. 这个类符合javabean规范。属性私有化,对外提供公开的setter和getter方法。
         3. 你还知道这个类当中有一个属性,属性的名字叫做 age
         4. 并且你还知道age属性的类型是int类型。
         请使用反射机制调用set方法,给User对象的age属性赋值。
         */
        String className = "Steps2_User";
        String propertype = "age";

        //获取类
        Class<?> clazz = Class.forName(className);
        //获取方法名
        String setMethodsName = "set" + propertype.toUpperCase().charAt(0) + propertype.substring(1);
        //根据属性名获取属性类型
        Field field = clazz.getDeclaredField(propertype);
        //获取方法
        Method declaredMethod = clazz.getDeclaredMethod(setMethodsName, field.getType());
        //准备对象
        Object obj = clazz.newInstance();
        //调用方法
        declaredMethod.invoke(obj, 21);

        System.out.println(obj);
    }
}
