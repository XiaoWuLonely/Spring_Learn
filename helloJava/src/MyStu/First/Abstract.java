package MyStu.First;

//抽象类
abstract class AbstractPoint{
    String name;
    int age;
    char sex;

    AbstractPoint(String name,int age,char sex){
        this.name=name;
        this.age=age;
        this.sex=sex;
    }

//    抽象方法--不能有方法体，只能声明
    abstract void show();
    abstract void work();
}

class Yina extends AbstractPoint{
    Yina(String name,int age,char sex){
        super(name,age,sex);
    }
    @Override
    public void show(){
        System.out.println("Show"+this.name+this.age+this.sex);
    }
    @Override
    public void work(){
        System.out.println("Work"+this.name+this.age+this.sex);

    }
}

public class Abstract {
    public static void main(String[] args) {
        Yina yn = new Yina("Yina",20,'女');
        yn.show();
        yn.work();
    }
}
