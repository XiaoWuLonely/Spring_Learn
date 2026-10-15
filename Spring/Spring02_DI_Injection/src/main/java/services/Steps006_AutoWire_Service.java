package services;

import dao.Steps006_AutoWire;

public class Steps006_AutoWire_Service {
    private Steps006_AutoWire steps006AutoWire;

    public void setSteps006AutoWire(Steps006_AutoWire steps006AutoWire) {
        this.steps006AutoWire = steps006AutoWire;
    }

    //生成订单方法
    public void generate() {
        steps006AutoWire.insert();
    }
}
