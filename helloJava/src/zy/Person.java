package zy;

public class Person {
    String name;
    Number age;
    String sex;
    Number score;

    String saiHi(){
        return "我是"+name+"，我今年"+age+"岁，我是"+sex+"，我考了"+score+"分";
    }
    String study(){
        return "我正在学习";
    }
}
