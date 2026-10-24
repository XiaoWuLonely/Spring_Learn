package Steps1.service.impl;

import Steps1.service.Steps1_OrderService;

// 代理对象(代理对象和目标对象要具有相同的行为,就要实现同一个或同一些接口。)
//客户端在使用代理对象的时候就像在使用目标对象一样。
public class Steps1_OrderServiceProxy implements Steps1_OrderService {
    //将目标对象作为代理对象的一个属性。这种关系叫做关联关系。比继承关系的耦合度低。
    //代理对象中含有目标对象的引用。关联关系。has a
    // 注意:这里要写一个公共接口类型。因为公共接口耦合度低。
    private Steps1_OrderService target;//这就是目标对象。目标对象一定是实现了OrderService接口的

    public Steps1_OrderServiceProxy(Steps1_OrderService target) {
        this.target = target;
    }


    @Override
    public void generate() {
        long being = System.currentTimeMillis();
        target.generate();
        long end = System.currentTimeMillis();
        System.out.println("耗时" + (being - end));
    }

    @Override
    public void modify() {
        long being = System.currentTimeMillis();
        target.modify();
        long end = System.currentTimeMillis();
        System.out.println("耗时" + (being - end));
    }

    @Override
    public void detail() {
        long being = System.currentTimeMillis();
        target.detail();
        long end = System.currentTimeMillis();
        System.out.println("耗时" + (being - end));
    }
}

