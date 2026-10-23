package service.impl;

import service.Steps1_OrderService;

//方法二，利用继承重写父类
public class Steps1_OrderServiceImplSub extends Steps1_OrderServiceImpl {
    @Override
    public void detail() {
        long being = System.currentTimeMillis();
        super.detail();
        long end = System.currentTimeMillis();
        System.out.println("耗时" + (being - end));
    }

    @Override
    public void generate() {
        super.generate();
    }

    @Override
    public void modify() {
        super.modify();
    }
}
