package MyStu.First;

import java.util.Scanner;

public class variable {
    public static void main(String[] args) {
//整数
        byte a1;// -128-127
        short a2;// -32768-32767
        int a3;// -2147483648-2147483647
        long a4;// -9223372036854775808-9223372036854775807

//浮点数
        float b1;//4字节32位
        double b2;//8字节64

//字符
        char c1;//2字节16位

//布尔
        boolean d1;//1字节8位

//        Scanner in
        System.out.println("身高（m）:");
        Scanner Tall = new Scanner(System.in);
        System.out.println("体重（KG）:");
        Scanner hevery = new Scanner(System.in);
        double tall = Tall.nextDouble();
        double height = hevery.nextDouble();

        double BMI=height/(tall * tall);
        System.out.println("Out:"+BMI);
    }
}
