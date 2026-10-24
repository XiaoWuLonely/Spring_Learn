# Spring11_GoF —— 设计模式与动态代理

> 从静态代理到 JDK 动态代理再到 CGLIB，掌握 AOP 的底层实现原理

## 知识点

### 学习路线

```
Steps1: 静态代理模式（手动编写代理类）
    ↓
Steps2: JDK 动态代理（基于接口，Proxy + InvocationHandler）
    ↓
Steps3: CGLIB 动态代理（基于继承，Enhancer + MethodInterceptor）
```

### 为什么需要代理模式？

**场景**：在不修改目标类代码的前提下，为目标类的方法增加额外功能（如计时、日志、事务）。

**三种实现方式对比**：

| 方式 | 原理 | 要求 | 优缺点 |
|---|---|---|---|
| **静态代理** | 手动编写代理类 | 代理类和目标类实现同一接口 | 代码冗余，编译时确定 |
| **JDK 动态代理** | 反射生成代理类 | 目标类必须实现接口 | 运行时动态生成，灵活 |
| **CGLIB 动态代理** | 字节码生成子类 | 目标类不能是 final | 无需接口，通过继承实现 |

### Steps1：静态代理

**核心思想**：代理类和目标类实现同一接口，代理类持有目标类的引用。

```java
// 接口
public interface OrderService {
    void generate();
}

// 目标类
public class OrderServiceImpl implements OrderService {
    @Override
    public void generate() {
        System.out.println("生成订单");
    }
}

// 代理类
public class OrderServiceProxy implements OrderService {
    private OrderService target;  // 持有目标对象引用
    
    public OrderServiceProxy(OrderService target) {
        this.target = target;
    }
    
    @Override
    public void generate() {
        long begin = System.currentTimeMillis();
        target.generate();  // 调用目标方法
        long end = System.currentTimeMillis();
        System.out.println("耗时: " + (end - begin) + "ms");
    }
}
```

**缺点**：每个目标类都需要一个对应的代理类，代码冗余。

### Steps2：JDK 动态代理

**核心类**：
- `java.lang.reflect.Proxy`：创建代理对象
- `java.lang.reflect.InvocationHandler`：调用处理器，定义增强逻辑

**关键方法**：

```java
Proxy.newProxyInstance(
    ClassLoader loader,        // 类加载器
    Class<?>[] interfaces,     // 目标类实现的接口
    InvocationHandler h        // 调用处理器
)
```

**InvocationHandler 实现**：

```java
public class MyInvocationHandler implements InvocationHandler {
    private Object target;  // 目标对象
    
    public MyInvocationHandler(Object target) {
        this.target = target;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 增强逻辑（前置）
        long begin = System.currentTimeMillis();
        
        // 调用目标方法
        Object result = method.invoke(target, args);
        
        // 增强逻辑（后置）
        long end = System.currentTimeMillis();
        System.out.println("耗时: " + (end - begin) + "ms");
        
        return result;  // 必须返回目标方法的返回值
    }
}
```

**使用方式**：

```java
OrderService target = new OrderServiceImpl();
OrderService proxy = (OrderService) Proxy.newProxyInstance(
    target.getClass().getClassLoader(),
    target.getClass().getInterfaces(),
    new MyInvocationHandler(target)
);
proxy.generate();  // 调用代理对象方法时，自动触发 invoke()
```

**invoke 方法三个参数**：
- `Object proxy`：代理对象引用（较少使用）
- `Method method`：目标方法
- `Object[] args`：目标方法的参数

### Steps3：CGLIB 动态代理

**适用场景**：目标类没有实现接口时，使用 CGLIB 通过继承生成子类作为代理。

**核心类**：
- `Enhancer`：字节码增强器，创建代理对象
- `MethodInterceptor`：方法拦截器（等同于 JDK 的 InvocationHandler）

**MethodInterceptor 实现**：

```java
public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        // 增强逻辑（前置）
        long begin = System.currentTimeMillis();
        
        // 调用目标方法
        Object result = proxy.invokeSuper(obj, args);
        
        // 增强逻辑（后置）
        long end = System.currentTimeMillis();
        System.out.println("耗时: " + (end - begin) + "ms");
        
        return result;
    }
}
```

**使用方式**：

```java
Enhancer enhancer = new Enhancer();
enhancer.setSuperclass(UserService.class);  // 设置父类（目标类）
enhancer.setCallback(new MyMethodInterceptor());  // 设置回调

UserService proxy = (UserService) enhancer.create();
proxy.login("admin", "123");  // 调用代理对象方法时，自动触发 intercept()
```

### 依赖配置

```xml
<!-- CGLIB -->
<dependency>
    <groupId>cglib</groupId>
    <artifactId>cglib</artifactId>
    <version>3.3.0</version>
</dependency>
```

## 关键技术点

| 技术 | 用途 |
|---|---|
| **Proxy** | JDK 动态代理核心类，创建代理对象 |
| **InvocationHandler** | JDK 动态代理调用处理器，定义增强逻辑 |
| **Enhancer** | CGLIB 字节码增强器，创建代理对象 |
| **MethodInterceptor** | CGLIB 方法拦截器，定义增强逻辑 |
| **Method.invoke()** | 反射调用目标方法 |
| **proxy.invokeSuper()** | CGLIB 调用父类（目标）方法 |

## 入口

- `src/test/java/Steps1_Action.java` —— 静态代理
- `src/test/java/Steps2_Action.java` —— JDK 动态代理
- `src/test/java/Steps3_Action.java` —— CGLIB 动态代理
