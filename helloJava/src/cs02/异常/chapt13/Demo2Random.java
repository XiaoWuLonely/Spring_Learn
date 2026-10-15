package edu.baiyun.chapt13;

import java.util.Random;

public class Demo2Random {
    public static void main(String[] args) {
        Random r = new Random();
        System.out.println("生成boolean随机数：" + r.nextBoolean());
        System.out.println("生成float随机数：" + r.nextFloat());
        System.out.println("生成double随机数：" + r.nextDouble());
        System.out.println("生成int随机数：" + r.nextInt());
        System.out.println("生成0~100之间int随机数：" + r.nextInt(100));
        System.out.println("生成long类型随机数：" + r.nextLong());
    }
}
