package edu.baiyun.chapt13;

import java.math.BigInteger;

public class DemoBigInteger {
    public static void main(String[] args) {
        // BigInteger只能使用传字符串的构造方法
        // long num = 10000000000000000000L; 超出了long范围
        BigInteger num1 = new BigInteger("10000000000000000000");
        BigInteger num2 = new BigInteger("3");
        BigInteger add = num1.add(num2);
        BigInteger subtract = num1.subtract(num2);
        BigInteger multiply = num1.multiply(num2);
        BigInteger divide = num1.divide(num2);
        BigInteger[] divideAndRemainder = num1.divideAndRemainder(num2);
        System.out.println("加法运算：" + add);
        System.out.println("减法运算：" + subtract.intValue());
        System.out.println("乘法运算：" + multiply.longValue());
        System.out.println("除法运算：" + divide);
        System.out.println("求余运算：" + divideAndRemainder[0] + "余" + divideAndRemainder[1]);
    }
}
