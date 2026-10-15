package edu.baiyun.chapt13;
public class DemoMath {
    public static void main(String[] args) {
        double num1 = 10;
        double num2 = 8;
        System.out.println("num1/num2向上取整：" + Math.ceil(num1/num2));
        System.out.println("num1/num2向下取整：" + Math.floor(num1/num2));
        System.out.println("num1/num2四舍五入：" + Math.round(num1/num2));
        System.out.println("num1和num2较小值：" + Math.min(num1, num2));
        System.out.println("num1和num2较大值：" + Math.max(num1, num2));
        System.out.println("num2的3次幂：" + Math.pow(num2, 3));
        System.out.println("num2开平方：" + Math.sqrt(num2));
        System.out.println("随机数：" + Math.random());
    }
}
