# Java 学习训练仓库

个人的 Java / Spring 学习练习仓库，按学习阶段组织代码。每个模块独立，可直接用 IDEA 打开运行。

## 技术栈

- Java 26
- Spring Framework 7.0.0-M9（spring-context）
- JUnit 4.13.2
- Log4j2 2.26.1（日志）
- Maven（构建）

## 项目结构

```
Java/
├── helloJava/                                      # Java SE 基础语法练习
└── Spring/                                         # Spring 框架训练（详见 Spring/Spring_README.md）
    ├── Spring01_FirstIoC/                          # 第一个 Spring 程序：IoC 容器入门
    ├── Spring02_DI_Injection/                      # 依赖注入（DI）专题
    ├── Spring03_Scope_Factory/                     # Bean 作用域 + 工厂模式
    ├── Spring04_instantiation/                     # Bean 实例化的四种方式
    ├── Spring05_LifeCycle/                         # Bean 完整生命周期
    └── Spring06_Circular_dependency_of_beans/      # Bean 循环依赖
```

## 模块导航

| 模块 | 简介 | 详细知识点 |
|---|---|---|
| **helloJava** | Java SE 基础：数据类型、流程控制、面向对象、异常、常用类 | → [helloJava_README.md](helloJava/helloJava_README.md) |
| **Spring** | Spring 框架 6 个递进模块，从 IoC 到循环依赖 | → [Spring_README.md](Spring/Spring_README.md) |
|  Spring01 | IoC 容器入门 | → [Spring01_IoC容器入门_README.md](Spring/Spring01_FirstIoC/Spring01_IoC容器入门_README.md) |
|  Spring02 | 依赖注入专题 | → [Spring02_依赖注入_README.md](Spring/Spring02_DI_Injection/Spring02_依赖注入_README.md) |
|  Spring03 | Bean 作用域 + 工厂模式 | → [Spring03_Bean作用域与工厂模式_README.md](Spring/Spring03_Scope_Factory/Spring03_Bean作用域与工厂模式_README.md) |
|  Spring04 | Bean 实例化方式 | → [Spring04_Bean实例化方式_README.md](Spring/Spring04_instantiation/Spring04_Bean实例化方式_README.md) |
|  Spring05 | Bean 生命周期 | → [Spring05_生命周期_README.md](Spring/Spring05_LifeCycle/Spring05_生命周期_README.md) |
|  Spring06 | 循环依赖 | → [Spring06_循环依赖_README.md](Spring/Spring06_Circular_dependency_of_beans/Spring06_循环依赖_README.md) |

## 学习路线

```
helloJava（Java SE 基础）
    ↓
Spring01（IoC 容器）→ Spring02（DI 注入）→ Spring03（作用域 + 工厂）
    ↓                                         ↓
Spring04（实例化方式）→ Spring05（生命周期）→ Spring06（循环依赖）
```

## 如何运行

1. 用 IDEA 打开对应模块目录（Maven 项目会自动识别 `pom.xml`）
2. 等待依赖下载完成
3. 运行 `src/test/java/` 下的 JUnit 测试类即可

> `helloJava` 不是 Maven 项目，直接用 IDEA 打开后运行 `src/` 下各类的 `main` 方法。
