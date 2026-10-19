# Spring08_Write_the_Spring —— 手写迷你 Spring 框架

> 从零实现一个迷你版 Spring IoC 容器，理解 Spring 底层原理

## 知识点

### 整体架构

```
com.myspringframework.core/          ← 手写的"迷你Spring"
  ├── ApplicationContext.java        ← 接口（定义 getBean 方法）
  └── ClassPathXmlAplicationContext.java  ← 核心实现类

com.powernode.myspring.bean/         ← 测试用的 Bean
  ├── Steps1_User.java               ← 普通 Bean（name, age）
  ├── Steps1_User_Dao.java           ← Dao 层
  └── Steps1_User_Service.java       ← Service 层（依赖 Dao）
```

### 核心实现：两遍遍历

构造函数的核心逻辑分两遍遍历 XML 中的 `<bean>` 标签：

**第一遍：创建所有 Bean 实例，存入 Map**

```
遍历 <bean> 标签
  ├── 读取 id 和 class 属性
  ├── Class.forName(class) 加载类
  ├── getDeclaredConstructor().newInstance() 创建对象
  └── Map.put(id, bean) 存入容器
```

为什么要先全部创建？因为 `ref` 注入时，被引用的 Bean 必须已经存在于 Map 中。

**第二遍：注入属性（DI）**

```
遍历 <bean> 标签的 <property> 子标签
  ├── value 注入（简单类型）
  │   ├── ConvertUtils.convert(value, field.getType()) 类型转换
  │   └── setMethod.invoke(bean, convertedValue) 调用 setter
  └── ref 注入（复杂类型）
      └── setMethod.invoke(bean, Map.get(ref)) 从 Map 取对象注入
```

### 关键技术点

| 技术 | 用途 |
|---|---|
| **dom4j** | 解析 XML 配置文件 |
| **反射** | `Class.forName()` 加载类、`newInstance()` 创建对象、`invoke()` 调用 setter |
| **Map** | 作为 IoC 容器，存储所有 Bean 实例 |
| **commons-beanutils** | `ConvertUtils.convert()` 自动将 String 转成目标类型（int、double 等） |

### 类型转换

XML 中的 `value` 属性读出来永远是 String，但 setter 方法可能需要 int、double 等类型：

```xml
<property name="age" value="21"/>  <!-- "21" 是 String，但 age 是 int -->
```

使用 `ConvertUtils.convert(value, field.getType())` 自动完成转换，不需要手动写 switch/if 判断类型。

### 两遍遍历的原因

如果只遍历一遍，处理 `<property name="userDao" ref="Dao_Bean">` 时，`Dao_Bean` 可能还没创建。

两遍遍历确保：
1. 第一遍结束后，所有 Bean 都已创建并存入 Map
2. 第二遍注入属性时，`ref` 引用的 Bean 一定能在 Map 中找到

## 入口

`src/test/java/Test1_Action.java`
