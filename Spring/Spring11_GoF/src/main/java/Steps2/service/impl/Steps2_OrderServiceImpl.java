package Steps2.service.impl;

import Steps2.service.Steps2_OrderService;

public class  Steps2_OrderServiceImpl implements Steps2_OrderService {
    @Override
    public String getName() {
        System.out.println("getName");
        return "张三";
    }

    @Override
    public void generate() {
        try {
            Thread.sleep(1234);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("生成");
    }

    @Override
    public void modify() {
        try {
            Thread.sleep(1234);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("修改");
    }

    @Override
    public void detail() {
        try {
            Thread.sleep(1234);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("详情");
    }
}
