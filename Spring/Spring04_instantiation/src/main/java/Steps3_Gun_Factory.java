public class Steps3_Gun_Factory {
    //工厂方法模式中的具体工厂角色中的方法是:实例方法。
    public Steps3_Gun get() {
// 实际上new这个对象还是我们程序员自己new的。
        return new Steps3_Gun();
    }
}