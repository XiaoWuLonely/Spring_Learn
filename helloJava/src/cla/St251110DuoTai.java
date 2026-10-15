package cla;

//父亲多态类
class AnimaldDuoTai{
    private String name;
    public AnimaldDuoTai(String name) {
        this.name=name;
    }
    public void speak(){}
    public String getName() {
        return name;
    }
}
//子类多态类
class DuoTaiDog extends AnimaldDuoTai{
     DuoTaiDog(String name) {
        super(name);
    }
    @Override
    public void speak(){
       System.out.println(getName()+"要讲话");
    }
}
//子类多态类
class DuoTaiCat extends AnimaldDuoTai{
     DuoTaiCat(String name) {
        super(name);
    }
    @Override
    public void speak(){
        System.out.println(getName()+"要讲话");
    }
}

//主函数
public class St251110DuoTai {
    //方法多态
    public static void function(AnimaldDuoTai animal){
        animal.speak();
    }
    public static void main(String[] args) {
        AnimaldDuoTai animal1=new DuoTaiDog("熊大");
        AnimaldDuoTai animal2=new DuoTaiCat("熊二");
        function(animal1);
        function(animal2);
    }

}
