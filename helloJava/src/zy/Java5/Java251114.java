package zy.Java5;

class Pet {
    private String name;
    private String simpleName;
    private String game;
    public Pet(String name,String simpleName) {
        this.name = name;
        this.simpleName=simpleName;
    }
    public void eat() {
        System.out.println("宠物吃");
    }

    public String getName() {
        return name;
    }
    public String getSimpleName() {
        return simpleName;
    }
    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }
}

class Dog extends Pet{
    public Dog(String name){
        super(name,"狗狗");
    }
    public void catchDisc(Pet pet){
        pet.setGame("玩抓飞盘");
    }
    public void eat(){
        System.out.println("狗狗吃骨头");
    }
}
class Cat extends Pet{
    public Cat(String name){
        super(name,"猫咪");
    }
    public void catchMouse(Pet pet){
        pet.setGame("玩捉老鼠");
    }
    public void eat(){
        System.out.println("猫咪吃鱼");
    }

}
class Dolphin extends Pet{
    public Dolphin(String name){
        super(name,"海豚");
    }
    public void runningCircle(Pet pet){
        pet.setGame("玩转圈圈");
    }
    public void eat(){
        System.out.println("海豚吃乌贼");
    }
}
class Master{
    private String name;
    public Master(String name){
        this.name=name;
    }
    public void feed(Pet pet){
        System.out.println(name+"喂名为" + pet.getName() + "的" + pet.getSimpleName());
    }
    public void play(Pet pet){
        if (pet instanceof Dog) {
            Dog dog = (Dog) pet;
            dog.catchDisc(pet);
        } else if (pet instanceof Cat) {
            Cat cat = (Cat) pet;
            cat.catchMouse(pet);
        } else if (pet instanceof Dolphin) {
            Dolphin dolphin = (Dolphin) pet;
            dolphin.runningCircle(pet);
        }
        System.out.println(name+"跟"+pet.getSimpleName()+pet.getGame());
    }
}

public class Java251114 {
    public static void main(String[] args) {
        Master master1 = new Master("张三");
        master1.feed(new Dog("小白"));
        master1.play(new Dog("小白"));

        Master master2=new Master("李四");
        master2.feed(new Cat("小花"));
        master2.play(new Cat("小花"));

        Master master3=new Master("王五");
        master3.feed(new Dolphin("白海豚"));
        master3.play(new Dolphin("白海豚"));
    }
}

