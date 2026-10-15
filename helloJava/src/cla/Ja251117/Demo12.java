package cla.Ja251117;

//颜色
abstract class Shape {
    protected String color;
    protected String name;

    public Shape(String color, String name) {
        this.color = color;
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String displayInfo() {
        return "这是" + color + "色的" + name;
    }

    public String getName() {
        return color;
    }

    public void setName(String name) {
        this.color = color;
    }


    //面积和周长方法
    public abstract double calculateArea();

    public abstract double calculatePerimeter();
}

//圆形
class Circle extends Shape {
    private double radius;

    public Circle(String color, double radius) {
        super(color, "圆形");
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius() {
        this.radius = radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

//长方形
class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(String color, double length, double width) {
        super(color, "长方形");
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
}

//三角形
class Triangle extends Shape {
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(String color, double sideA, double sideB, double sideC) {
        super(color, "三角形");
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }


    @Override
    public double calculateArea() {
        double s = (sideA + sideB + sideC) / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }
}

public class Demo12 {
    public static void main(String[] args) {
        Shape circle = new Circle("red", 5);
        Shape rectangle = new Rectangle("blue", 10, 20);
        Shape triangle = new Triangle("green", 5, 5, 5);
        C(circle);
        R(rectangle);
        T(triangle);
    }

    public static void C(Shape circle) {
        System.out.println(circle.displayInfo() + "\n" + "圆的面积: " + circle.calculateArea() + "圆的周长: " + circle.calculatePerimeter() + "圆的颜色: " + circle.color + circle.name);
    }

    public static void R(Shape rectangle) {
        System.out.println(rectangle.displayInfo() + "\n" + "长方形的面积: " + rectangle.calculateArea() + "长方形的周长: " + rectangle.calculatePerimeter() + "长方形的颜色: " + rectangle.color);
    }

    public static void T(Shape triangle) {
        System.out.println(triangle.displayInfo() + "\n" + "三角形的面积: " + triangle.calculateArea() + "三角形的周长: " + triangle.calculatePerimeter() + "三角形的颜色: " + triangle.color);
    }
}
