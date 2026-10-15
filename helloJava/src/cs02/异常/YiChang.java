package cs02.异常;

import java.util.Scanner;

public class YiChang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A, B, C;

        System.out.println("请输入三个整数：");

        // 检查第一个输入是否为整数
        if (sc.hasNextInt()) {
            A = sc.nextInt();
        } else {
            throw new IllegalArgumentException("输入的第一个值必须是整数！");
        }

        // 检查第二个输入是否为整数
        if (sc.hasNextInt()) {
            B = sc.nextInt();
        } else {
            throw new IllegalArgumentException("输入的第二个值必须是整数！");
        }

        // 检查第三个输入是否为整数
        if (sc.hasNextInt()) {
            C = sc.nextInt();
        } else {
            throw new IllegalArgumentException("输入的第三个值必须是整数！");
        }

        // 值不能为空
        if (A == 0 || B == 0 || C == 0) {
            throw new IllegalArgumentException("这三个整数不能为0！");
        }

        try{
            String res = judge(A,B,C);
            System.out.println(res);
        }catch (IllegalArgumentException e) {
            // 这个catch中处理IllegalArgumentException
            // 输出异常文本
            System.out.println("程序发生了非法参数异常："+e.getMessage());
        }catch (ArrayIndexOutOfBoundsException e) {
            // 这个catch中处理ArrayIndexOutOfBoundsException
            // 打印异常
            e.printStackTrace();
        }finally {
            // 不管是否发生异常，最终都会执行finally
            System.out.println("程序运行完毕");
        }
    }
    private static String judge(int A,int B,int C) throws IllegalArgumentException{
        if(A+B<=C||A+C<=B||B+C<=A){
            throw new IllegalArgumentException("这三个整数不能构成三角形！");
        }
        return "这三个整数可以构成三角形！ 周长是："+(A+B+C);
    }
}
