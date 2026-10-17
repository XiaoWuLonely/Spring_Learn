# Spring02_DI_Injection —— 依赖注入专题

> Spring DI（Dependency Injection）各种注入方式

## 知识点

### 1. set 方法注入

通过 `<property>` 标签 + setter 方法注入属性值，最常用的注入方式：

```xml
<bean id="user" class="User">
    <property name="name" value="张三"></property>
</bean>
```

### 2. 构造器注入

通过 `<constructor-arg>` 标签 + 构造方法注入属性值，保证 Bean 创建时依赖就绑定：

```xml
<bean id="user" class="User">
    <constructor-arg index="0" value="张三"></constructor-arg>
</bean>
```

### 3. 级联属性赋值

对嵌套对象的属性进行赋值（如 `user.address.city`），要求内层对象已实例化：

```xml
<property name="address">
    <bean class="Address">
        <property name="city" value="北京"></property>
    </bean>
</property>
```

### 4. 数组 / 集合注入

通过 `<list>`、`<set>`、`<array>`、`<map>`、`<props>` 等标签注入集合类型：

```xml
<property name="hobbies">
    <list>
        <value>读书</value>
        <value>游泳</value>
    </list>
</property>
```

### 5. 数据源注入

将 `DataSource` 对象（如 Druid）作为 Bean 注入，包含 `driverClassName`、`url`、`username`、`password` 等属性。

### 6. 自动装配（Autowire）

| 模式 | 说明 |
|---|---|
| `byName` | 按属性名匹配容器中的 Bean id |
| `byType` | 按属性类型匹配，容器中同类型 Bean 必须唯一 |

```xml
<bean id="user" class="User" autowire="byName"></bean>
```

### 7. 引入外部 properties 文件

通过 `<context:property-placeholder>` 引入 `jdbc.properties` 等外部配置文件，用 `${key}` 占位符引用值，实现配置与代码分离。

## 配置文件速查

| 配置文件 | 训练内容 |
|---|---|
| `spring1_set.xml` | set 方法注入 |
| `spring2_constructor.xml` | 构造器注入 |
| `spring03_jilian.xml` | 级联属性赋值 |
| `Spring04_Set_Array.xml` | 数组 / 集合注入 |
| `Spring05_DataSource.xml` | 内置数据源注入 |
| `spring3_jdbc.xml` | 自定义数据源 |
| `Spring006_AutoWire.xml` | 自动装配 byName |
| `Steps007_AutoWare_Bytype.xml` | 自动装配 byType |
| `Steps008_OutDataSource.xml` | 外部 properties 引入 |

## 入口

`src/test/java/` 下对应的测试类
