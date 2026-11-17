# Spring Boot 学习板块

> ← 返回总览：[Java 学习训练仓库](../README.md)

通过独立模块学习 Spring Boot Web 开发、Spring Bean 管理与依赖注入。

## 学习路线

```
Sp001_REST_API → Spring Boot 应用启动与第一个 REST 接口
    ↓
Sp002_Bean_DI   → Spring Bean 管理、依赖注入与配置读取
```

## 模块速查

| 模块 | 核心知识点 |
|---|---|
| **Sp001_REST_API** | Spring Boot 启动类、组件扫描、`@RestController`、`@GetMapping` |
| **Sp002_Bean_DI** | `@Service`、`ApplicationContext.getBean`、`@Autowired`、`@Configuration`、`@Value`、YAML 配置 |

## Sp001_REST_API：第一个 REST 接口

- `MyApplication` 使用 `@SpringBootApplication` 标记启动类，并通过 `SpringApplication.run` 启动应用。
- `myctl` 使用 `@RestController` 和 `@GetMapping("/sayhi")` 声明 GET 接口，返回字符串 `sayHello`。
- 控制器位于启动类所在包的子包中，可由 Spring Boot 的默认组件扫描发现。

## Sp002_Bean_DI：Spring Bean 与依赖注入

- `UserServiceImpl` 使用 `@Service` 注册为 Spring Bean，并实现 `UserService` 接口。
- `HeistApplication` 从 `ApplicationContext` 中按名称和类型获取 `UserService` Bean，调用服务后关闭容器。
- 测试类使用 `@SpringBootTest` 启动应用上下文，并用 `@Autowired` 注入 `UserService`。
- `AppConfig` 使用 `@Configuration` 注册配置类，再通过 `@Value("${myapp.path}")` 注入 YAML 中的配置值。
- 控制器将 GET 请求 `/heist` 映射到 `index` 方法。

## 公共技术栈

- Java 26
- Spring Boot 4.1.2
- Maven

## 如何运行

1. 用 IDEA 打开对应模块目录（Maven 项目会自动识别 `pom.xml`）
2. 等待依赖下载完成
3. 在 `Sp001_REST_API` 中运行 `MyApplication`，或在 `Sp002_Bean_DI` 中运行 `HeistApplication`
