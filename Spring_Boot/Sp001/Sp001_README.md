# Sp001 —— Spring Boot 入门

> 创建 Spring Boot 应用入口，并通过 REST 控制器返回文本响应

## 知识点

### Maven 父工程与 Web MVC 依赖

`pom.xml` 继承 `spring-boot-starter-parent`（版本 `4.1.2`），并声明 `spring-boot-starter-webmvc`。父工程统一管理 Spring Boot 相关依赖和 Maven 配置，因此本模块的 starter 没有单独写版本号。项目将 Java 编译版本设为 26。

### Spring Boot 启动类

```java
@SpringBootApplication
public class MyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}
```

`main` 方法调用 `SpringApplication.run` 启动应用。`@SpringBootApplication` 标记应用配置入口；组件扫描从启动类所在包 `oolong.heist` 开始，因此控制器位于它的子包 `oolong.heist.controller`，可以被扫描到。

### REST 控制器与 GET 接口

```java
@RestController
public class myctl {
    @GetMapping("/sayhi")
    public String sayHello() {
        return "sayHello";
    }
}
```

- `@RestController` 将控制器的返回值作为响应体处理。
- `@GetMapping("/sayhi")` 将 GET 请求映射到 `sayHello` 方法。
- 方法返回字符串 `sayHello`，作为接口响应内容。

本章展示了应用启动和单个 GET 接口的基本结构，尚未涉及请求参数、业务服务层或数据库访问。

## 入口

- `src/main/java/oolong/heist/MyApplication.java` —— Spring Boot 应用入口
- `src/main/java/oolong/heist/controller/myctl.java` —— `/sayhi` GET 接口
- `pom.xml` —— Java 版本、Spring Boot 父工程和 Web MVC starter
