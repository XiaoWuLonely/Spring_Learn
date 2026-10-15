package MyStu.First;

//继承
class Animal{
    String name;
    Animal(String name){
        this.name=name;
    }
    public void speak(){
        System.out.println(name+" is speaking");
    }
}

class Dog extends Animal{
     private String name;
     Dog(String name){
        super(name);
        this.name=name;
    }
    public String getName(){
         return this.name;
    }

//    方法重写
    @Override
    public void speak(){
        System.out.println(name+" "+"Barks");
    }
}

public class Extent {
    public static void main(String[] args) {
        Animal a = new Animal("Loi");
        Dog d = new Dog("Buddy");
        a.speak();
        d.speak();
        System.out.println(d.getName());
    }
}
