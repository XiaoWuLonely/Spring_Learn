package bean;

public class Steps3_Jilian_Student {
    private String name;
    private Steps3_Jilian_Class steps3JilianClass;

    //Setter
    public void setName(String name) {
        this.name = name;
    }

    public void setSteps3JilianClass(Steps3_Jilian_Class steps3JilianClass) {
        this.steps3JilianClass = steps3JilianClass;
    }

//Setter
//使用级联属性必须写getter
    public Steps3_Jilian_Class getSteps3JilianClass() {
        return steps3JilianClass;
    }

    @Override
    public String toString() {
        return "Steps3_Jilian_Student{" +
                "name='" + name + '\'' +
                ", steps3JilianClass=" + steps3JilianClass +
                '}';
    }
}
