# Spring 框架训练

> ← 返回总览：[Java_README.md](../README.md)

基于 Spring Framework 7.0.0-M9，通过 12 个递进模块系统学习 Spring 核心概念。

## 学习路线

```
Spring01_FirstIoC          → 认识 IoC 容器，会配 Bean、会取 Bean
    ↓
Spring02_DI_Injection      → 掌握各种依赖注入方式与自动装配
    ↓
Spring03_Scope_Factory     → 理解 Bean 作用域，用工厂模式理解对象创建的设计思想
    ↓
Spring04_instantiation     → 掌握 Bean 实例化的四种方式，理解 FactoryBean 的设计意图
    ↓
Spring05_LifeCycle         → 完整追踪 Bean 从创建到销毁的每个回调节点
    ↓
Spring06_Circular_dependency → 理解循环依赖的本质及 Spring 三级缓存解决思路
    ↓
Spring07_Review_the_reflex → 回顾反射机制，理解 Spring IoC 底层原理的基础
    ↓
Spring08_Write_the_Spring  → 从零手写迷你 Spring IoC 容器，融会贯通
    ↓
Spring09_IOC_Annotations   → 掌握 Spring IoC 注解驱动开发
    ↓
Spring10_JdbcTemplate      → 使用 JdbcTemplate 简化数据库操作
    ↓
Spring11_GoF               → 设计模式与动态代理（AOP 基础）
    ↓
Spring11_AOP               → Spring AOP 面向切面编程
```

## 模块速查

| 模块 | 核心知识点 | 详细知识点 |
|---|---|---|
| Spring01_FirstIoC | IoC 容器、XML 配置 Bean、`getBean` | → [Spring01_IoC容器入门_README.md](Spring01_FirstIoC/Spring01_IoC容器入门_README.md) |
| Spring02_DI_Injection | set/构造器注入、级联赋值、集合注入、自动装配、外部 properties | → [Spring02_依赖注入_README.md](Spring02_DI_Injection/Spring02_依赖注入_README.md) |
| Spring03_Scope_Factory | singleton/prototype、自定义作用域、简单工厂 vs 工厂方法 | → [Spring03_Bean作用域与工厂模式_README.md](Spring03_Scope_Factory/Spring03_Bean作用域与工厂模式_README.md) |
| Spring04_instantiation | 无参构造、静态工厂、实例工厂、`FactoryBean` | → [Spring04_Bean实例化方式_README.md](Spring04_instantiation/Spring04_Bean实例化方式_README.md) |
| Spring05_LifeCycle | Aware 回调、BeanPostProcessor、init/destroy | → [Spring05_生命周期_README.md](Spring05_LifeCycle/Spring05_生命周期_README.md) |
| Spring06_Circular_dependency | setter/构造器循环依赖、singleton/prototype、三级缓存 | → [Spring06_循环依赖_README.md](Spring06_Circular_dependency_of_beans/Spring06_循环依赖_README.md) |
| Spring07_Review_the_reflex | `Class.forName`、`Method.invoke`、反射调用 setter | → [Spring07_反射机制_README.md](Spring07_Review_the_reflex/Spring07_反射机制_README.md) |
| Spring08_Write_the_Spring | dom4j 解析 XML、反射实例化、两遍遍历注入属性 | → [Spring08_手写Spring_README.md](Spring08_Write_the_Spring/Spring08_手写Spring_README.md) |
| Spring09_IOC_Annotations | 自定义注解、包扫描、@Component/@Service/@Autowired/@Resource、纯注解配置 | → [Spring09_IoC注解_README.md](Spring09_IOC_Annotations/Spring09_IoC注解_README.md) |
| Spring10_JdbcTemplate | 数据源配置、JdbcTemplate CRUD、德鲁伊连接池、BeanPropertyRowMapper | → [Spring10_JdbcTemplate_README.md](Spring10_JdbcTemplate/Spring10_JdbcTemplate_README.md) |
| Spring11_GoF | 静态代理、JDK 动态代理、CGLIB 动态代理、InvocationHandler、MethodInterceptor | → [Spring11_设计模式与动态代理_README.md](Spring11_GoF/Spring11_设计模式与动态代理_README.md) |
| Spring11_AOP | 五种通知类型、切点表达式、@Pointcut 复用、@Order 顺序、@EnableAspectJAutoProxy | → [Spring11_AOP_面向切面编程_README.md](Spring11_AOP/Spring11_AOP_面向切面编程_README.md) |

## 公共技术栈

- Java 26
- Spring Framework 7.0.0-M9（`spring-context`）
- JUnit 4.13.2（测试）
- Log4j2 2.26.1 + SLF4J2（日志）
- Maven（构建）

## 如何运行

1. 用 IDEA 打开对应模块目录（自动识别 `pom.xml`）
2. 等待依赖下载完成
3. 运行 `src/test/java/` 下的 JUnit 测试类
