package edu.baiyun.chapt13;

import java.math.BigDecimal;

public class DemoBigDecimal {
    public static void main(String[] args) {
        // 必须传入字符串，否则依然精度不准确
        BigDecimal num1 = new BigDecimal("0.1");
        BigDecimal num2 = new BigDecimal("0.2");
        System.out.println("double运算：" + (0.1 + 0.2));
        System.out.println("BigDecimal运算："+num1.add(num2));
        BigDecimal num3 = new BigDecimal("31");
        BigDecimal num4 = new BigDecimal("20");
        System.out.println("不保留小数位：" + num3.divide(num4));
        System.out.println("ROUND_HALF_UP：" + num3.divide(num4, 1, BigDecimal.ROUND_HALF_UP));
        System.out.println("ROUND_HALF_DOWN：" + num3.divide(num4, 1, BigDecimal.ROUND_HALF_DOWN));
        System.out.println("ROUND_CEILING：" + num3.divide(num4, 1, BigDecimal.ROUND_CEILING));
        System.out.println("ROUND_FLOOR：" + num3.divide(num4, 1, BigDecimal.ROUND_FLOOR));
    }
}
