package cs01;

public class java004loop {
    public static void main(String[] args) {
        int a=10;
        //后执行
        while(a>0){
            System.out.println(a--);
        }


        int x = 10;

        //先执行
        do{
            System.out.print("value of x : " + x );
            x--;
            System.out.print("\n");
        }while( x >0 );

        //for循环
        for(int y = 10; y >0; y--) {
            System.out.print("value of y : " + y );
            System.out.print("\n");
        }
    }
}
