package cs01;

public class java003if {
    public static void main(String[] args){
        //三元运算
        int a , b;
        a = 10;
        // 如果 a 等于 1 成立，则设置 b 为 20，否则为 30
        b = (a == 1) ? 20 : 30;
        System.out.println( "Value of b is : " +  b );

        // 如果 a 等于 10 成立，则设置 b 为 20，否则为 30
        b = (a == 10) ? 20 : 30;
        System.out.println( "Value of b is : " + b );

        System.out.println("if");
        //if 判断
        if(a==10){
            System.out.println( "Value of a is 10");
        }else{
            System.out.println( "Value of a is not 10");
        }
        System.out.println("else if");
        a=30;
        //else if 再判断
        if(a==10){
            System.out.println( "Value of a is 10");
        } else if (a==20) {
            System.out.println( "Value of a is 20");
        }else{
            System.out.println( "Value of a is not 20|10");
        }



        //判断字符类型
        String card = "lll";
        boolean result =  card instanceof String;
        System.out.println( result);
    }
}
