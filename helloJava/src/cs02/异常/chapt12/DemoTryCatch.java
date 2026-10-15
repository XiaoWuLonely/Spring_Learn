package cs02.异常.chapt12;


import java.util.Scanner;

public class DemoTryCatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = {"北京", "上海", "武汉", "广州", "深圳"};
        System.out.println("请输入要获取的城市索引");
        int index = scanner.nextInt();
        try {
            // 可能出现异常的代码，用try包住
            String value = getValue(arr, index);
            System.out.println("您获取的城市为：" + value);
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
    // 在方法上声明异常
    private static String getValue(String[] arr, int index)
            throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        // 对参数进行校验
        if (arr == null) {
            // 抛出非法参数异常，并指定提示文本
            throw new IllegalArgumentException("数组不能为空！");
        }
        if (index < 0) {
            throw new IllegalArgumentException("索引不能为负数！");
        }
        if (index >= arr.length) {
            // 抛出数组索引越界异常
            throw new ArrayIndexOutOfBoundsException("索引不可以超过数组长度！");
        }
        return arr[index];
    }
}
