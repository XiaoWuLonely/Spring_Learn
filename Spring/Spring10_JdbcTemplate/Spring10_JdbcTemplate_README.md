# Spring10_JdbcTemplate —— Spring JdbcTemplate

> 使用 Spring JdbcTemplate 简化数据库操作，掌握数据源配置与 CRUD 操作

## 知识点

### 学习路线

```
Steps1: 自定义数据源 + JdbcTemplate 配置
    ↓
Steps2: 德鲁伊连接池 + JdbcTemplate 查询
```

### 核心概念

**JdbcTemplate** 是 Spring 对 JDBC 的封装，简化数据库操作：
- 自动管理连接（获取、关闭）
- 简化 SQL 执行（不需要手动创建 Statement、处理 ResultSet）
- 提供类型转换（BeanPropertyRowMapper 自动映射）

### 数据源配置

**方式一：自定义数据源**

```java
public class MyDataSource implements DataSource {
    private String driver;
    private String url;
    private String username;
    private String password;
    
    // setter 方法（用于 Spring 注入）
    
    @Override
    public Connection getConnection() throws SQLException {
        Class.forName(driver);
        return DriverManager.getConnection(url, username, password);
    }
}
```

**方式二：使用德鲁伊连接池（推荐）**

```xml
<bean id="DataSource" class="com.alibaba.druid.pool.DruidDataSource">
    <property name="driverClassName" value="com.mysql.cj.jdbc.Driver"/>
    <property name="url" value="jdbc:mysql://localhost:3306/spring_learn"/>
    <property name="username" value="root"/>
    <property name="password" value="mysql"/>
</bean>
```

### JdbcTemplate 配置

```xml
<!-- 配置 JdbcTemplate，注入数据源 -->
<bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
    <property name="dataSource" ref="DataSource"/>
</bean>
```

### 查询操作

**查询单条数据**

```java
String sql = "SELECT id, real_name, age FROM user WHERE id = ?";
User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), 1);
```

**查询多条数据**

```java
String sql = "SELECT id, real_name, age FROM user";
List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
```

**BeanPropertyRowMapper** 自动将 ResultSet 映射为 Java 对象：
- 数据库字段 `real_name` → Java 属性 `realName`（下划线转驼峰）
- 要求：数据库字段名与 Java 属性名对应（忽略大小写和下划线）

### 依赖配置

```xml
<!-- Spring JDBC -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-jdbc</artifactId>
    <version>7.0.9</version>
</dependency>

<!-- MySQL 驱动 -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.33</version>
</dependency>

<!-- 德鲁伊连接池 -->
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid</artifactId>
    <version>1.2.28</version>
</dependency>
```

## 关键技术点

| 技术 | 用途 |
|---|---|
| **DataSource** | 数据源接口，提供数据库连接 |
| **JdbcTemplate** | Spring JDBC 核心类，封装 SQL 操作 |
| **DruidDataSource** | 德鲁伊连接池，高性能数据源实现 |
| **BeanPropertyRowMapper** | 自动将查询结果映射为 Java 对象 |

## 入口

- `src/test/java/Steps1_Action.java` —— 自定义数据源 + JdbcTemplate 配置
- `src/test/java/Steps2_Action.java` —— 德鲁伊连接池 + 查询多条数据
