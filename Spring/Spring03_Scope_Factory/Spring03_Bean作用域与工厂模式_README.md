# Spring03_Scope_Factory —— Bean 作用域 + 工厂模式

> 理解 Bean 作用域，用工厂模式理解对象创建的设计思想

## 知识点

### 1. Bean 作用域

| 作用域 | 说明 |
|---|---|
| `singleton` | 默认值，容器中只有一个实例，每次 `getBean()` 返回同一对象 |
| `prototype` | 每次 `getBean()` 创建新实例 |
| 自定义作用域 | 通过 `SimpleThreadScope` 注册 `threadScope`，实现线程级作用域 |

```xml
<bean id="user" class="User" scope="singleton"></bean>
<bean id="user2" class="User" scope="prototype"></bean>
```

### 2. 简单工厂模式（Easy_Factory）

一个静态工厂方法根据传入的类型参数生产所有产品。

**问题**：新增产品时必须修改工厂代码，违背 **OCP（开闭原则）**；工厂承担所有产品的创建逻辑，违背 **单一职责原则**。

### 3. 工厂方法模式（Factory）

每种产品对应一个独立工厂，每个工厂只负责创建一种产品。

**解决**：新增产品只需新增对应工厂类，不修改已有代码，满足 OCP 和单一职责。

### 设计思想对比

| | 简单工厂 | 工厂方法 |
|---|---|---|
| 工厂数量 | 1 个 | 每种产品 1 个 |
| 新增产品 | 修改工厂（违背 OCP） | 新增工厂类（满足 OCP） |
| 职责 | 工厂承担所有产品创建 | 每个工厂只负责一种产品 |

## 入口

- 作用域：`src/test/java/Steps1_Score_Action.java`，配置 `src/main/resources/Steps1_Score.xml`
- 工厂模式：`src/test/java/` 下对应测试类
