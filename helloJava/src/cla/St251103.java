package cla;

import java.util.Objects;

public class St251103 extends Object {
    String name;
    int age;

    public void eat() {
        System.out.println(age + "岁的" + name + "在吃饭");
    }

    @Override
    public String toString() {
        return "St251103{" +
                "name='" + name + "'" +
                ",age=" + age + "}";
    }

    @Override
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(obj==null||getClass()!=obj.getClass()){
            return false;
        }
        St251103 st251103=(St251103) obj;
        return age == st251103.age && name.equals(st251103.name);

    }
    @Override
    public int hashCode(){
        return Objects.hash(name,age);
    }
}
