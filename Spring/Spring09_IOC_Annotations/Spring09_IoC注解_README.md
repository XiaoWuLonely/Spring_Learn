# Spring09_IOC_Annotations —— Spring IoC 注解

> 从自定义注解到 Spring 官方注解，掌握 IoC 的注解驱动开发方式

## 知识点

### 学习路线

```
Steps1: 自定义注解 + 反射读取注解
    ↓
Steps2: 手写包扫描机制（扫描包 → 识别注解 → 实例化 → 存入Map）
    ↓
Steps3: Spring官方注解（@Component/@Service/@Controller/@Repository）
    ↓
Steps5: component-scan 过滤机制（use-default-filters + include-filter）
    ↓
Steps6: @Value 属性注入
    ↓
Steps7: @Autowired + @Qualifier 自动装配
    ↓
Steps8: @Resource 按名称注入
    ↓
Steps9: 纯注解配置模式（@Configuration + @ComponentScan）
```

### Java 注解基础

**元注解**：标注注解的注解

| 元注解 | 作用 |
|---|---|
| `@Target` | 修饰注解可以出现的位置（TYPE=类上，FIELD=属性上，METHOD=方法上） |
| `@Retention` | 注解保留阶段（RUNTIME=运行时可通过反射读取） |

**自定义注解示例**：

```java
@Target(ElementType.TYPE)      // 只能标注在类上
@Retention(RetentionPolicy.RUNTIME)  // 运行时可反射读取
public @interface Component {
    String value();  // 属性名是value时，使用时可省略
}
```

**反射读取注解**：

```java
Class<?> aClass = Class.forName("bean.User");
if (aClass.isAnnotationPresent(Component.class)) {
    Component annotation = aClass.getAnnotation(Component.class);
    String id = annotation.value();  // 获取注解属性值
}
```

### 包扫描机制（手写实现）

核心思路：已知包名 → 扫描包下所有 .class 文件 → 识别带注解的类 → 实例化 → 存入 Map

```java
// 1. 用类加载器获取包的物理路径
URL url = ClassLoader.getSystemClassLoader().getResource(packageName);
String path = url.getPath();

// 2. 遍历目录下所有文件
File file = new File(path);
File[] files = file.listFiles();

// 3. 加载每个类，检查是否有@Component注解
for (File f : files) {
    String className = packageName + "." + f.getName().split("\\.")[0];
    Class<?> aClass = Class.forName(className);
    
    if (aClass.isAnnotationPresent(Component.class)) {
        Component annotation = aClass.getAnnotation(Component.class);
        String id = annotation.value();
        Object bean = aClass.newInstance();
        beanMap.put(id, bean);  // 存入容器
    }
}
```

### Spring 官方注解

Spring 提供 4 个注解用于声明 Bean，功能相同，语义不同：

| 注解 | 语义 | 使用场景 |
|---|---|---|
| `@Component` | 通用组件 | 不好归类时使用 |
| `@Service` | 业务层 | Service 类 |
| `@Controller` | 控制层 | Controller 类 |
| `@Repository` | 持久层 | Dao 类 |

**默认命名规则**：注解 value 省略时，Bean 的 id 默认为类名首字母小写

```java
@Service
public class OrderService {}  // Bean id = "orderService"

@Service("myOrderService")
public class OrderService {}  // Bean id = "myOrderService"
```

### component-scan 配置

**XML 配置方式**：

```xml
<!-- 基础包扫描 -->
<context:component-scan base-package="com.example"/>

<!-- 关闭默认过滤器，只扫描指定注解 -->
<context:component-scan base-package="com.example" use-default-filters="false">
    <context:include-filter type="annotation" 
                           expression="org.springframework.stereotype.Controller"/>
</context:component-scan>
```

**纯注解方式**（替代 XML）：

```java
@Configuration
@ComponentScan({"steps9.Dao", "steps9.service"})
public class SpringConfig {
}

// 启动容器
ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
```

### 依赖注入注解

#### @Value：属性注入

```java
@Component
public class MyDataSource {
    @Value("com.mysql.cj.jdbc.Driver")
    private String driver;
    
    @Value("root")
    private String username;
}
```

不需要 setter 方法，直接注入值。

#### @Autowired：按类型注入

```java
@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;  // 按类型查找并注入
}
```

**问题**：当同一接口有多个实现类时，无法确定注入哪一个。

**解决**：配合 `@Qualifier` 按名字注入

```java
@Autowired
@Qualifier("orderDaoImplByOracle")  // 指定Bean的id
private OrderDao orderDao;
```

#### @Resource：按名称注入（JSR-250标准）

```java
@Service
public class OrderService {
    @Resource(name = "orderDaoImpl")
    private OrderDao orderDao;
}
```

**@Autowired vs @Resource 对比**：

| 特性 | @Autowired | @Resource |
|---|---|---|
| 来源 | Spring 提供 | Java 标准（JSR-250） |
| 默认策略 | 按类型（byType） | 按名称（byName） |
| 多实现时 | 需配合 @Qualifier | 直接用 name 属性 |

## 关键技术点

| 技术 | 用途 |
|---|---|
| **元注解** | `@Target`、`@Retention` 定义自定义注解 |
| **反射** | `isAnnotationPresent()`、`getAnnotation()` 读取注解 |
| **ClassLoader** | `getResource()` 获取包的物理路径 |
| **AnnotationConfigApplicationContext** | 纯注解方式启动 Spring 容器 |

## 入口

- `src/test/java/ReflectAnnotationTest1.java` —— 反射读取注解
- `src/test/java/Steps3_Action.java` —— 官方注解 + XML配置
- `src/test/java/Steps5_Action.java` —— component-scan 过滤
- `src/test/java/Steps6_Action.java` —— @Value 注入
- `src/test/java/Steps7_Action.java` —— @Autowired + @Qualifier
- `src/test/java/Steps8_Action.java` —— @Resource 注入
- `src/test/java/Steps9_Action.java` —— 纯注解配置
