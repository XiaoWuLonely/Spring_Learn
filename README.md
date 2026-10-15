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
├── helloJava/                      # Java SE 基础语法练习
└── Spring/                         # Spring 框架训练
    ├── Spring01_FirstIoC/          # 第一个 Spring 程序：IoC 容器入门
    ├── Spring02_DI_Injection/      # 依赖注入（DI）专题
    └── Spring03_Scope_Factory/     # Bean 作用域 + 工厂模式
```

## 模块说明

### helloJava —— Java SE 基础

Java 语法入门练习，按日期和章节组织：

- `cs01/`：基础语法（数据类型、分支、循环、数组、方法、继承、多态、String、IO、日期）
- `cs02/`：异常处理（try-catch、throws、自定义异常）、常用类（Math、Random、Date、Calendar、BigDecimal、BigInteger）
- `cla/`、`zy/`、`MyStu/`：面向对象练习（封装、继承、多态、抽象类、接口、内部类）

### Spring01_FirstIoC —— 第一个 Spring 程序

Spring IoC 容器入门：

- 启动 IoC 容器（`ClassPathXmlApplicationContext`）
- XML 方式配置 Bean（`class` + `id`）
- `getBean` 两种用法：按 id 获取 Object / 按 id + 类型获取
- 同时加载多个配置文件（`spring.xml` / `bean.xml` / `util/Date.xml`）
- 第三方类（`java.util.Date`）注册为 Bean
- Log4j2 日志输出

入口：`src/test/java/FirstSpring1.java`

### Spring02_DI_Injection —— 依赖注入专题

Spring DI（Dependency Injection）各种注入方式：

| 配置文件 | 训练内容 |
|---|---|
| `spring1_set.xml` | set 方法注入 |
| `spring2_constructor.xml` | 构造器注入（含简单类型） |
| `spring03_jilian.xml` | 级联属性赋值 |
| `Spring04_Set_Array.xml` | 数组 / 集合注入 |
| `Spring05_DataSource.xml` | 内置数据源注入 |
| `spring3_jdbc.xml` | 自定义数据源（Druid 风格模拟） |
| `Spring006_AutoWire.xml` | 自动装配 byName |
| `Steps007_AutoWare_Bytype.xml` | 自动装配 byType |
| `Steps008_OutDataSource.xml` | 引入外部 properties 配置文件（`jdbc.properties`） |

入口：`src/test/java/` 下对应的测试类

### Spring03_Scope_Factory —— Bean 作用域 + 工厂模式

- **Bean 作用域**：`singleton`（单例）与自定义 `threadScope`（`SimpleThreadScope` 注册自定义作用域）
  - 配置：`src/main/resources/Steps1_Score.xml`
  - 入口：`src/test/java/Steps1_Score_Action.java`
- **简单工厂模式**（`Easy_Factory/`）：一个静态工厂方法根据类型生产所有产品；理解其违背 OCP（开闭原则）的问题
- **工厂方法模式**（`Factory/`）：一种产品对应一个工厂，解决简单工厂的 OCP 与单一职责问题

## 如何运行

1. 用 IDEA 打开对应模块目录（Maven 项目会自动识别 `pom.xml`）
2. 等待依赖下载完成
3. 运行 `src/test/java/` 下的 JUnit 测试类即可

> `helloJava` 不是 Maven 项目，直接用 IDEA 打开后运行 `src/` 下各类的 `main` 方法。

## 学习路线

```
helloJava（Java SE 基础）
    ↓
Spring01_FirstIoC（认识 IoC 容器，会配 Bean、会取 Bean）
    ↓
Spring02_DI_Injection（掌握各种依赖注入方式与自动装配）
    ↓
Spring03_Scope_Factory（理解 Bean 作用域，用工厂模式理解对象创建的设计思想）
```
