public class Steps2_Start_Factory {
    // 工厂类中有一个静态方法。
// 简单工厂模式又叫做:静态工厂方法模式。
    public static Steps2_Start get() {
//这个Star对象最终实际上创建的时候还是我们负责new的对象。
        return new Steps2_Start();
    }
}
