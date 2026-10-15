package edu.baiyun.chapt13;

import java.util.Random;

public class Demo1Random {
    public static void main(String[] args) {
        Random random = new Random(13);
        for(int x=0; x<10; x++){
            System.out.println(random.nextInt(100));
        }
    }
}
