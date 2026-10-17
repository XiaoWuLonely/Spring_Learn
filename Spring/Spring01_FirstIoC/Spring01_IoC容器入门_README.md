# Spring01_FirstIoC —— 第一个 Spring 程序

> IoC 容器入门：启动容器、XML 配置 Bean、获取 Bean

## 知识点

### 1. 启动 IoC 容器

使用 `ClassPathXmlApplicationContext` 加载 classpath 下的 XML 配置文件，启动 Spring 容器：

```java
ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
```

### 2. XML 方式配置 Bean

通过 `<bean>` 标签将类注册到容器，`id` 指定 Bean 的唯一标识，`class` 指定全限定类名：

```xml
<bean id="myBean" class="com.example.MyBean"></bean>
```

### 3. `getBean` 两种用法

| 方式 | 代码 | 特点 |
|---|---|---|
| 按 id 获取 | `context.getBean("myBean")` | 返回 `Object`，需要强转 |
| 按 id + 类型获取 | `context.getBean("myBean", MyBean.class)` | 类型安全，推荐 |

### 4. 多配置文件加载

可以同时加载多个 XML 配置文件，实现配置的模块化管理：

- `spring.xml`
- `bean.xml`
- `util/Date.xml`

### 5. 第三方类注册为 Bean

不仅自定义类可以注册为 Bean，`java.util.Date` 等 JDK 内置类同样可以通过 XML 配置注册到容器中。

## 入口

`src/test/java/FirstSpring1.java`
