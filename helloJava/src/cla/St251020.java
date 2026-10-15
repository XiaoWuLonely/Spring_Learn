package cla;

public class St251020 {
    public static void main(String[] args) {
        Circle c1=new Circle();
        c1.radius=5;
        System.out.println(c1.area());
        System.out.println(c1.girth());


        Circle c2=new Circle();
        System.out.println(c2.getRadius(10));
    }
}

