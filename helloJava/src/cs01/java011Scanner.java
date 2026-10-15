package cs01;

import java.util.*;

public class java011Scanner {
    public static void main(String[] args){
        //获取控制台输入
        Scanner s =new Scanner(System.in);
        System.out.println("next方式接受请输入");
        if(s.hasNext()){
            String str = s.next();
            String str1 = s.nextLine();
            System.out.println(str+str1);
        }
        s.close();
    }
}
