public class Steps1_User {

    /**
     * * Bean的生命周期按照粗略的五步的话:
     * 第一步:实例化Bean(调用无参数构造方法。)
     * * 第二步:给Bean属性赋值(调用set方法。)
     * (会调用Bean的init方法。注意:这个init方法需要自己写,自己配。)
     * * 第五步:销毁Bean(会调用Bean的destroy方法。注意:这个destroy方法需要自己写,自己配。)
     * * 第三步:初始化Bean
     * * 第四步:使用Bean
     */
    private String name;

    public Steps1_User() {
        System.out.println("First:构造函数");

    }

    public void setName(String name) {
        this.name = name;
        System.out.println("Second:给对象赋值");
    }


    public void initBean() {
        System.out.println("Third:init Bean");
    }

    public void destroyBean() {
        System.out.println("Five:Destroy Bean");
    }
}
