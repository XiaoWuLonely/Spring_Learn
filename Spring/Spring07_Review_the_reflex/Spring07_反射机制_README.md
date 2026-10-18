# Spring07_Review_the_reflex —— 反射机制回顾

> 回顾 Java 反射机制，理解 Spring IoC 底层原理的基础

## 知识点

### Step 1：反射调用方法

通过反射机制动态加载类并调用方法，理解方法调用的"四要素"：

| 四要素 | 说明 | 反射实现 |
|---|---|---|
| 调用哪个对象 | 目标实例 | `clazz.newInstance()` 创建对象 |
| 调用哪个方法 | 方法名 + 参数类型 | `clazz.getDeclaredMethod("doSome", String.class, int.class)` |
| 传什么参数 | 实际参数值 | `method.invoke(obj, "李四", 21)` |
| 返回什么值 | 方法返回值 | `Object retValue = method.invoke(...)` |

**核心 API：**

```java
// 1. 加载类
Class<?> clazz = Class.forName("Steps1_Reflex");

// 2. 获取方法（需要方法名 + 参数类型来区分重载方法）
Method method = clazz.getDeclaredMethod("doSome", String.class, int.class);

// 3. 创建对象
Object obj = clazz.newInstance();

// 4. 调用方法
Object retValue = method.invoke(obj, "李四", 21);
```

**关键点：**
- `Class.forName()` 通过类名字符串加载类，运行时动态确定
- `getDeclaredMethod()` 需要参数类型来区分同名重载方法
- `invoke()` 的第一个参数是调用对象，后面是方法参数

### Step 2：反射调用 JavaBean 的 setter 方法

通过反射动态调用 setter 方法给 JavaBean 属性赋值，这是 Spring 依赖注入的底层原理。

**场景：** 已知类名、属性名、属性类型，用反射调用对应的 setter 方法。

```java
String className = "Steps2_User";
String property = "age";

// 1. 拼接 setter 方法名：set + 首字母大写 + 剩余部分
String setMethodName = "set" + property.toUpperCase().charAt(0) + property.substring(1);
// 结果："setAge"

// 2. 获取类
Class<?> clazz = Class.forName(className);

// 3. 获取方法（需要参数类型）
Method method = clazz.getDeclaredMethod(setMethodName, int.class);

// 4. 创建对象（调用无参构造函数）
Object obj = clazz.newInstance();

// 5. 调用 setter 方法
method.invoke(obj, 21);
```

**执行流程：**

| 步骤 | 发生了什么 | name | age |
|---|---|---|---|
| 1. `clazz.newInstance()` | 调用无参构造函数 | `null` | `0` |
| 2. `invoke(obj, 21)` | 调用 `setAge(21)` | `null` | `21` |
| 3. `println(obj)` | 调用 `toString()` | `null` | `21` |

**关键点：**
- `clazz.newInstance()` 调用的是**无参构造函数**，字段都是默认值
- setter 方法名需要动态拼接：`"set" + 属性名首字母大写 + 剩余部分`
- 这就是 Spring 通过 XML 配置 `<property name="age" value="21"/>` 注入属性的底层实现

## 与 Spring 的关系

反射机制是 Spring IoC 的核心基础：

| 反射操作 | Spring 中的对应 |
|---|---|
| `Class.forName("ClassName")` | 读取 XML 中的 `class="ClassName"` |
| `clazz.newInstance()` | 创建 Bean 实例 |
| `getDeclaredMethod("setXxx", type)` | 查找 setter 方法 |
| `method.invoke(obj, value)` | 注入属性值 |

Spring 的 XML 配置：
```xml
<bean id="user" class="Steps2_User">
    <property name="age" value="21"/>
</bean>
```

底层就是靠反射实现的：
1. 根据 `class` 属性加载类并创建实例
2. 根据 `property name` 拼接 setter 方法名
3. 根据 `value` 的类型调用对应的 setter 方法注入值

## 入口

- Step 1（反射调用方法）：`src/test/java/Steps1_Action.java`
- Step 2（反射调用 setter）：`src/test/java/Steps2_Action.java`
