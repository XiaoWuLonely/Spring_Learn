package Steps1.service.impl;

import Steps1.service.Steps1_OrderService;

public class Steps1_OrderServiceImpl implements Steps1_OrderService {
    //方法一
    //如果一下每个方法都算计时，复用性极差、而且违背sop。
    @Override
    public void generate() {
        //模拟耗时
        try {
            Thread.sleep(1234);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("生成");
    }

    @Override
    public void modify() {        //模拟耗时
        try {
            Thread.sleep(1234);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("修改");
    }

    @Override
    public void detail() {        //模拟耗时
        try {
            Thread.sleep(1234);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("详情");
    }
}
