package edu.baiyun.chapt13;
public class DemoInteger {
    public static void main(String[] args) {
        // 通过构造方法创建一个Integer
        Integer num1 = new Integer("12315");
        System.out.println("构造方法创建Integer对象：" + num1);
        // 通过valueOf将int转换成Integer
        Integer num2 = Integer.valueOf(10086);
        System.out.println("valueOf转换Integer对象：" + num2);
        // 通过intValue将Integer转换成int
        int num3 = num2.intValue();
        System.out.println("调用intValue方法：" + num3);
        // 通过parseInt将字符串转换成int
        int num4 = Integer.parseInt("12306");
        System.out.println("parseInt方法将字符串转int：" + num4);
        String s1 = Integer.toString(10010);
        System.out.println("Integer.toString转换字符串：" + s1);
        String s2 = num2.toString();
        System.out.println("Integer转字符串：" + s2);
        // 除此之外，拼接字符串也可以将基本类型或者包装类转字符串
        String s3 = num4 + "";
        String s4 = num2 + "";
        System.out.println("拼接字符串方式转换：" + s3 + "," + s4);
        // 包装类可以为null
        Integer num5 = null;
        System.out.println("包装类num5值：" + num5);
    }
}

