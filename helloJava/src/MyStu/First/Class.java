package MyStu.First;


//类
class Point{
    int x;
    static int y;//静态变量 会共享
    Point(int x,int y ){
        this.x=x;
        Point.y=y;//类成员 用类名访问好一些
    }

    public void print(){
        System.out.println("print()=>"+this.x+" "+this.y);
    }
    static void PrintStatic(){
        System.out.println("print()=>"+Point.y);
    }
}


public class Class {
    public static void main(String[] args) {
        Point point = new Point(1,2);
        System.out.println(point.x+" "+point.y);
        Point point2 = new Point(3,4);
        System.out.println(point2.x+" "+point.y);
        System.out.println(point.x+" "+point.y);

        point2.print();
        Point.PrintStatic();
    }
}
