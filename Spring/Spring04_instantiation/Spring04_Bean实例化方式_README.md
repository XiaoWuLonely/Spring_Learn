# Spring04_instantiation —— Bean 实例化方式

> 逐步演示 Spring 实例化 Bean 的四种方式

## 知识点

### Step 1：无参构造实例化

最基础的方式。Spring 调用类的无参构造方法创建 Bean 实例。

```xml
<bean id="myBean" class="Steps1_SpringBean"></bean>
```

**要求**：类必须提供 public 无参构造器。

### Step 2：静态工厂方法实例化

工厂类提供 **static** 方法返回 Bean 实例，Spring 通过 `class` + `factory-method` 调用：

```xml
<bean id="myBean" class="Steps2_Start_Factory" factory-method="get"></bean>
```

- 不需要创建工厂实例，直接调用静态方法
- 此模式也称"静态工厂方法模式"

### Step 3：实例工厂方法实例化

工厂的 `get()` 方法是 **实例方法**（非 static），需要两步配置：

```xml
<!-- 1. 先创建工厂实例 -->
<bean id="factory" class="Steps3_Gun_Factory"></bean>
<!-- 2. 指定工厂实例 + 工厂方法 -->
<bean id="myBean" factory-bean="factory" factory-method="get"></bean>
```

- `factory-bean` 引用工厂实例的 id
- `factory-method` 指定实例方法名
- 对应设计模式中的"工厂方法模式"

### Step 4：FactoryBean 接口（简化 Step 3）

实现 `FactoryBean<T>` 接口，Spring 自动调用 `getObject()` 获取 Bean：

| 方法 | 作用 |
|---|---|
| `getObject()` | 返回实际 Bean 实例 |
| `getObjectType()` | 返回 Bean 类型 |
| `isSingleton()` | 是否单例，默认 `true` |

```xml
<!-- 配置简洁，无需 factory-bean / factory-method -->
<bean id="myBean" class="Steps4_Person_Factory"></bean>
```

**关键**：`getBean("myBean")` 返回的是 `getObject()` 的结果，不是 Factory 本身。

### Step 5：FactoryBean 实战 —— 自定义日期解析

用 `FactoryBean<Date>` 解析自定义格式的日期字符串并注入到 Student 中：

```java
public Date getObject() throws Exception {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    return sdf.parse(strBirth);
}
```

**解决的问题**：`java.util.Date` 无法通过标准 Spring 配置从任意格式字符串创建，FactoryBean 提供了灵活的构造手段。

## 总结对比

| 方式 | XML 属性 | 特点 |
|---|---|---|
| 无参构造 | `class` | 最简单，默认方式 |
| 静态工厂 | `class` + `factory-method` | 工厂方法为 static |
| 实例工厂 | `factory-bean` + `factory-method` | 需先创建工厂实例 |
| FactoryBean | `class`（实现接口） | Spring 风格，最简洁 |

## 入口

`src/test/java/Steps1_2_3_4_5Action.java`
