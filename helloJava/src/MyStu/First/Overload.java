package MyStu.First;

//方法重载
class TheOverLoad{
    int a;
    int b;
    int c;
    TheOverLoad(int a,int b,int c){
        this.a=a;
        this.b=b;
        this.c=c;
    }
    TheOverLoad(int a){
        this.a=a;
    }
    TheOverLoad(int a,int b){
        this.a=a;
        this.b=b;
    }
    public void getABC(){
        System.out.println("a="+this.a+" b="+this.b+" c="+this.c);
    }
}

public class Overload {
    public static void main(String[] args) {
        TheOverLoad ob1=new TheOverLoad(10);
        TheOverLoad ob2=new TheOverLoad(10,20);
        TheOverLoad ob3=new TheOverLoad(10,20,30);
        ob1.getABC();
        ob2.getABC();
        ob3.getABC();
    }
}
