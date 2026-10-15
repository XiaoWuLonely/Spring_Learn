package cs02.异常.chapt12;


import java.util.Scanner;

public class DemoLogin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入用户名：");
        String username = scanner.next();
        System.out.print("请输入密码：");
        String password = scanner.next();
        try {
            login(username, password);
            // 如果方法成功运行完毕，说明两个异常都没有触发，登录成功
            System.out.println("登录成功");
        }catch (edu.baiyun.chapt12.UserNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }catch (edu.baiyun.chapt12.PasswordWrongException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    private static void login(String username, String password)
            throws edu.baiyun.chapt12.UserNotFoundException, edu.baiyun.chapt12.PasswordWrongException {
        if(!"admin".equals(username)) {
            // 用户名不存在，对于用户而言要提示用户名或密码错误，但开发者需要能知道真正的原因
            throw new edu.baiyun.chapt12.UserNotFoundException("用户名或密码错误！");
        }
        if(!"123456".equals(password)) {
            // 密码错误
            throw new edu.baiyun.chapt12.PasswordWrongException("用户名或密码错误！");
        }
    }
}
