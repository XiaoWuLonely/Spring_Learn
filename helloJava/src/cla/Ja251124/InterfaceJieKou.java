package cla.Ja251124;

//接口
interface Icomparable {
    public abstract boolean compareTo(Object obj);//抽象方法：比较两个图形
}

interface IDraw {
    void draw();//抽象方法：绘制图像
}

interface IShape extends Icomparable, IDraw {
    public static final double PI = 3.14;
}

class Circle extends Shape implements IShape {
    private double radius;//属性:半径

    public Circle(double radius) { //构造方法
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public boolean compareTo(Object obj) {
        Circle circle = (Circle) obj;
        return this.radius == circle.radius;
    }

    @Override
    public void draw() {
        System.out.println("Draw a circle,radius is " + radius);
    }

    @Override
    public double area() {
        return PI * radius * radius;
    }

    @Override
    public double girth() {
        return 2 * PI * radius;
    }
}

//抽象类
abstract class Shape {
    public abstract double area();//面积
    public abstract double girth();//周长
}

public class InterfaceJieKou {
    public static void main(String[] args) {
        Shape shape = new Circle(6);
        IShape ishape = new Circle(3);
        System.out.println("半径为6的面积：" + String.format("%.2f", shape.area()) + "周长：" + shape.girth());
        ishape.draw();
        System.out.println("两个园相同：" + ishape.compareTo(shape));
    }
}
