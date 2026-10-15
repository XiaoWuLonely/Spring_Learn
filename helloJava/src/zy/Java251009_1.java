package zy;

import java.util.Scanner;

public class Java251009_1 {
    public static void main(String[] args) {
        Scanner Any=new Scanner(System.in);
        System.out.println("请输入1-7的整数");
        switch (Any.nextInt()){
            case 1:
                System.out.println("今天是星期一");
                break;
            case 2:
                System.out.println("今天是星期二");
                break;
            case 3:
                System.out.println("今天是星期三");
                break;
            case 4:
                System.out.println("今天是星期四");
                break;
            case 5:
                System.out.println("今天是星期五");
                break;
            case 6:
                System.out.println("今天是星期六");
                break;
            case 7:
                System.out.println("今天是星期七");
                break;
            default:
                System.out.println("不是1-7的整数");
        }
    }
}
