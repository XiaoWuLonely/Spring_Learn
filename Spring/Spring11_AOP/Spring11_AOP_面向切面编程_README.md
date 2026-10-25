# Spring11_AOP —— Spring 面向切面编程

> 从 AOP 概念到五种通知类型，掌握 Spring AOP 的 XML 配置和纯注解配置方式

## 知识点

### 学习路线

```
Steps1: XML 配置 AOP
  ├── 切面、通知、切点概念
  ├── 五种通知类型（@Before/@After/@AfterReturning/@AfterThrowing/@Around）
  ├── 多切面执行顺序（@Order）
  ├── 切点复用（@Pointcut）
  └── JoinPoint 获取方法信息
    ↓
Steps2: 纯注解配置 AOP
  └── @EnableAspectJAutoProxy 开启 AOP 代理
```

### 核心概念

| 术语 | 含义 | 示例 |
|---|---|---|
| **Aspect（切面）** | 横切关注点的模块化封装 | `@Aspect` 标注的类 |
| **JoinPoint（连接点）** | 程序执行的某个时刻（如方法调用） | `JoinPoint` 对象 |
| **Pointcut（切点）** | 匹配连接点的表达式 | `execution(* Steps1.service..*(..))` |
| **Advice（通知/增强）** | 切面在特定连接点执行的代码 | `@Before`、`@After` 等 |
| **Target（目标对象）** | 被通知的对象 | 业务类 |
| **AOP Proxy（代理）** | AOP 创建的代理对象 | JDK 动态代理 / CGLIB |
| **Weaving（织入）** | 将切面应用到目标对象的过程 | Spring 在运行时创建代理 |

### 五种通知类型

```java
@Aspect
@Component
public class LogAspect {
    
    // 1. 前置通知：目标方法执行前
    @Before("execution(* service..*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("前置通知");
    }
    
    // 2. 后置通知：目标方法正常返回后
    @AfterReturning("execution(* service..*(..))")
    public void afterReturningAdvice() {
        System.out.println("后置通知");
    }
    
    // 3. 环绕通知：包裹目标方法，可控制是否执行
    @Around("execution(* service..*(..))")
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前");
        Object result = pjp.proceed();  // 执行目标方法
        System.out.println("环绕后");
        return result;
    }
    
    // 4. 最终通知：无论是否异常都执行
    @After("execution(* service..*(..))")
    public void afterAdvice() {
        System.out.println("最终通知");
    }
    
    // 5. 异常通知：目标方法抛出异常时
    @AfterThrowing("execution(* service..*(..))")
    public void afterThrowingAdvice() {
        System.out.println("异常通知");
    }
}
```

**执行顺序**（正常情况）：
```
环绕前 → 前置 → 目标方法 → 后置 → 最终 → 环绕后
```

**执行顺序**（异常情况）：
```
环绕前 → 前置 → 目标方法(异常) → 异常 → 最终 → 环绕后(不执行)
```

### 切点表达式 execution

**语法**：
```
execution(修饰符 返回类型 包名.类名.方法名(参数) 异常)
```

**常用示例**：

| 表达式 | 含义 |
|---|---|
| `execution(* com.service.UserService.*(..))` | UserService 类的所有方法 |
| `execution(* com.service..*(..))` | com.service 包及子包下所有类的所有方法 |
| `execution(* com.service.*.*(..))` | com.service 包下所有类的所有方法（不含子包） |
| `execution(public * *(..))` | 所有 public 方法 |
| `execution(* *(String, ..))` | 第一个参数是 String 的方法 |

**通配符**：
- `*`：匹配单个元素（类名、方法名、参数）
- `..`：匹配多个元素（子包、任意参数）

### 切点复用 @Pointcut

**定义切点**：
```java
@Pointcut("execution(* Steps1.service..*(..))")
public void 通用切点() {}
```

**引用切点**：
```java
// 同类中引用
@Before("通用切点()")
public void beforeAdvice() { }

// 跨类引用（全限定名）
@Before("Steps1.utils.LogAspect.通用切点()")
public void beforeAdvice() { }
```

### 多切面顺序 @Order

```java
@Aspect
@Component
@Order(1)  // 数字越小，优先级越高
public class SecurityAspect { }

@Aspect
@Component
@Order(2)
public class LogAspect { }
```

**执行顺序**：
- 前置通知：Order 值小的先执行
- 后置通知：Order 值小的后执行（类似洋葱模型）

### JoinPoint 获取方法信息

```java
@Before("通用切点()")
public void beforeAdvice(JoinPoint joinPoint) {
    // 获取方法签名
    String methodName = joinPoint.getSignature().getName();
    
    // 获取参数
    Object[] args = joinPoint.getArgs();
    
    // 获取目标对象
    Object target = joinPoint.getTarget();
}
```

### XML 配置方式

**Steps1.xml**：
```xml
<!-- 组件扫描 -->
<context:component-scan base-package="Steps1"/>

<!-- 开启 AspectJ 自动代理 -->
<!-- proxy-target-class="true" 使用 CGLIB 代理 -->
<!-- proxy-target-class="false"（默认）使用 JDK 动态代理 -->
<aop:aspectj-autoproxy proxy-target-class="true"/>
```

### 纯注解配置方式

**Steps2_SpringConfig.java**：
```java
@Configuration
@ComponentScan("Steps2")
@EnableAspectJAutoProxy(proxyTargetClass = true)  // 开启 AOP 代理
public class Steps2_SpringConfig {
}
```

**启动容器**：
```java
ApplicationContext ctx = new AnnotationConfigApplicationContext(Steps2_SpringConfig.class);
```

### 依赖配置

```xml
<!-- Spring AOP -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-aop</artifactId>
    <version>7.0.9</version>
</dependency>

<!-- AspectJ Weaver -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-aspects</artifactId>
    <version>7.0.9</version>
</dependency>
```

## 关键技术点

| 技术 | 用途 |
|---|---|
| **@Aspect** | 标记切面类 |
| **@Before** | 前置通知 |
| **@After** | 最终通知（无论是否异常） |
| **@AfterReturning** | 后置通知（正常返回） |
| **@AfterThrowing** | 异常通知 |
| **@Around** | 环绕通知（最强大） |
| **@Pointcut** | 定义可复用的切点 |
| **@Order** | 控制多切面执行顺序 |
| **JoinPoint** | 获取连接点信息 |
| **ProceedingJoinPoint** | 环绕通知专用，可控制目标方法执行 |
| **@EnableAspectJAutoProxy** | 纯注解方式开启 AOP |
| **execution** | 切点表达式语法 |

## 入口

- `src/test/java/Steps1.java` —— XML 配置 AOP
- `src/test/java/Steps2.java` —— 纯注解配置 AOP
