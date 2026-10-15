package cla;

public class Circle {
    double radius;
    double area(){
            return Math.PI * radius * radius;
        }
    double girth(){
            return 2*Math.PI*radius;
        }

        double getRadius(double radius){
            return  radius*radius;
        }
}
