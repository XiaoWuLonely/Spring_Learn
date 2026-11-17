package oolong.heist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//提醒:这个HelloController要想被spring容器管理,这个类所在的位置必须满足:和SpringBoot主入口程序在同级目录下,或者子目录下。
//@Controller
@RestController
public class myctl {
    @GetMapping("/sayhi")
//    @ResponseBody
    public String sayHello() {
        return "sayHello";
    }
}
