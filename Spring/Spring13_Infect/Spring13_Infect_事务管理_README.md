# Spring13_Infect - Spring 事务管理

## 本章概览

本章学习 Spring 事务管理，包括声明式事务管理、事务传播行为、事务隔离级别以及基于注解的配置方式。

---

## 一、事务管理概述

### 1.1 什么是事务

事务（Transaction）是数据库操作的最小逻辑单元，具有 **ACID** 特性：
- **A（Atomicity）原子性**：事务中的操作要么全部成功，要么全部失败回滚
- **C（Consistency）一致性**：事务前后数据保持一致性
- **I（Isolation）隔离性**：并发事务之间互不干扰
- **D（Durability）持久性**：事务提交后数据永久保存

### 1.2 Spring 事务管理方式

1. **编程式事务管理**：通过代码手动控制事务（少用）
2. **声明式事务管理**：通过注解或 XML 配置（推荐）

---

## 二、声明式事务管理（Steps1）

### 2.1 核心配置

#### XML 配置事务管理器

```xml
<!-- 配置事务管理器 -->
<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
    <property name="dataSource" ref="dataSource"/>
</bean>

<!-- 开启事务注解驱动 -->
<tx:annotation-driven transaction-manager="transactionManager"/>
```

#### 使用 @Transactional 注解

```java
@Service
@Transactional  // 类级别：所有方法都有事务
public class AccountServiceImpl implements AccountService {
    
    @Override
    public void transfer(String fromActno, String toActno, double money) {
        // 转账操作：扣款 + 入账
        // 任何一步失败，整个事务回滚
    }
}
```

### 2.2 接口 vs 实现类

**重要原则**：使用接口类型接收 Bean，不要使用实现类类型。

```java
// ✅ 正确：使用接口类型
AccountService accountService = applicationContext.getBean("accountServiceImpl", AccountService.class);

// ❌ 错误：使用实现类类型（会报 BeanNotOfRequiredTypeException）
AccountServiceImpl accountService = applicationContext.getBean("accountServiceImpl", AccountServiceImpl.class);
```

**原因**：Spring AOP 使用 JDK 动态代理时，代理对象实现了接口，但不是实现类的子类。

---

## 三、事务传播行为

### 3.1 什么是事务传播

当一个事务方法被另一个事务方法调用时，Spring 如何管理事务的传播行为。

### 3.2 七种传播行为

| 传播行为 | 说明 |
|---------|------|
| **REQUIRED**（默认） | 如果当前有事务，就加入；如果没有，就新建一个 |
| **SUPPORTS** | 如果当前有事务，就加入；如果没有，就以非事务方式执行 |
| **MANDATORY** | 必须在一个已有事务中运行，否则抛出异常 |
| **REQUIRES_NEW** | 不论当前是否有事务，都新建一个新事务（挂起当前事务） |
| **NOT_SUPPORTED** | 以非事务方式执行，如果当前有事务，则挂起 |
| **NEVER** | 以非事务方式执行，如果当前有事务，则抛出异常 |
| **NESTED** | 如果当前有事务，则在嵌套事务中执行；如果没有，等同于 REQUIRED |

### 3.3 REQUIRED vs REQUIRES_NEW 演示

```java
// AccountServiceImpl（主服务）
@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    
    @Resource(name = "accountServiceImpl2")
    private AccountService accountService;
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED)  // 加入当前事务
    public void save(String actno, double money) {
        try {
            accountService.save(actno, money);  // 调用 Impl2
        } catch (Exception e) {
            System.out.println("捕获异常: " + e.getMessage());
        }
        accountDao.insert(actno, money);  // 继续执行
    }
}

// AccountServiceImpl2（辅助服务）
@Service
public class AccountServiceImpl2 implements AccountService {
    
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)  // 开新事务
    public void save(String actno, double money) {
        accountDao.insert(actno, money);
        throw new RuntimeException("Impl2 故意抛异常");  // 新事务回滚
    }
}
```

**执行结果**：
- Impl2 抛异常 → 事务B 回滚
- Impl1 捕获异常 → 事务A 不受影响，正常提交

**关键区别**：
- `REQUIRED`：加入当前事务，一荣俱荣，一损俱损
- `REQUIRES_NEW`：独立新事务，互不影响

---

## 四、事务隔离级别（Steps2）

### 4.1 并发事务问题

| 问题 | 说明 |
|------|------|
| **脏读** | 读取到未提交的数据 |
| **不可重复读** | 同一事务中，两次读取同一数据不一致（被修改） |
| **幻读** | 同一事务中，两次查询同一条件的数据量不一致（被插入/删除） |

### 4.2 五种隔离级别

| 隔离级别 | 脏读 | 不可重复读 | 幻读 |
|---------|------|-----------|------|
| **READ_UNCOMMITTED** | ✓ | ✓ | ✓ |
| **READ_COMMITTED** | ✗ | ✓ | ✓ |
| **REPEATABLE_READ**（MySQL 默认） | ✗ | ✗ | ✓ |
| **SERIALIZABLE** | ✗ | ✗ | ✗ |
| **DEFAULT** | 使用数据库默认级别 | - | - |

### 4.3 设置隔离级别

```java
// READ_UNCOMMITTED：可以读取未提交的数据
@Transactional(isolation = Isolation.READ_UNCOMMITTED)
public void getByActno(String actno) {
    Steps2_Account account = accountDao.selectByActno(actno);
    System.out.println("信息：" + account);
}

// READ_COMMITTED：只能读取已提交的数据
@Transactional(isolation = Isolation.READ_COMMITTED)
public void getByActno(String actno) {
    Steps2_Account account = accountDao.selectByActno(actno);
    System.out.println("信息：" + account);
}
```

---

## 五、事务其他属性

### 5.1 timeout 超时时间

```java
@Transactional(timeout = 5)  // 设置超时时间为 5 秒
public void save(Account act) {
    accountDao.insert(act);
    Thread.sleep(6000);  // 超过 5 秒，事务回滚
    accountDao.insert(act);
}
```

**注意**：超时时间指的是最后一条 DML 语句执行之前的时间。

### 5.2 readOnly 只读事务

```java
@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true)
public void getByActno(String actno) {
    // 只读事务：只允许 SELECT，不允许 INSERT/UPDATE/DELETE
    // 作用：启动 Spring 的优化策略，提高查询效率
    Account account = accountDao.selectByActno(actno);
}
```

**建议**：如果事务中只有查询操作，设置为只读事务可以提升性能。

### 5.3 rollbackFor 回滚异常

```java
// 默认：只有 RuntimeException 和 Error 才会回滚
@Transactional
public void save(Account act) throws IOException {
    accountDao.insert(act);
    throw new IOException("检查型异常");  // 不会回滚！
}

// 指定：IOException 也触发回滚
@Transactional(rollbackFor = IOException.class)
public void save(Account act) throws IOException {
    accountDao.insert(act);
    throw new IOException("检查型异常");  // 会回滚
}

// 指定：RuntimeException 及其子类都回滚
@Transactional(rollbackFor = RuntimeException.class)
public void save(Account act) {
    accountDao.insert(act);
    throw new RuntimeException("运行时异常");  // 会回滚
}
```

**默认行为**：
- ✓ RuntimeException：回滚
- ✓ Error：回滚
- ✗ 检查型异常（如 IOException）：不回滚

---

## 六、基于注解的配置（Steps3）

### 6.1 使用 @Configuration 替代 XML

```java
@Configuration
@ComponentScan("Steps3")
@EnableTransactionManagement  // 开启事务管理
public class Steps3_Config {
    
    @Bean("dataSource")
    public DruidDataSource getDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring_learn");
        dataSource.setUsername("root");
        dataSource.setPassword("mysql");
        return dataSource;
    }
    
    @Bean("jdbcTemplate")
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }
    
    @Bean("transactionManager")
    public DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }
}
```

### 6.2 加载配置类

```java
// 使用 AnnotationConfigApplicationContext 加载配置类
ApplicationContext ctx = new AnnotationConfigApplicationContext(Steps3_Config.class);
```

### 6.3 核心注解

| 注解 | 作用 |
|------|------|
| `@Configuration` | 声明配置类，替代 XML 配置文件 |
| `@Bean` | 将方法返回值注册为 Spring Bean |
| `@ComponentScan` | 指定组件扫描包路径 |
| `@EnableTransactionManagement` | 开启声明式事务管理 |

---

## 七、常见错误与解决方案

### 7.1 BeanNotOfRequiredTypeException

**错误**：`expected AccountServiceImpl but was jdk.proxy1.$Proxy33`

**原因**：使用实现类类型接收 JDK 动态代理对象

**解决**：使用接口类型接收
```java
// ❌ 错误
AccountServiceImpl service = ctx.getBean("accountServiceImpl", AccountServiceImpl.class);

// ✅ 正确
AccountService service = ctx.getBean("accountServiceImpl", AccountService.class);
```

### 7.2 @Resource 找不到 name 属性

**错误**：`@Resource("jdbcTemplate")` 编译失败

**原因**：`@Resource` 使用 `name` 属性，不是 `value`

**解决**：
```java
// ❌ 错误
@Resource("jdbcTemplate")
private JdbcTemplate jdbcTemplate;

// ✅ 正确
@Resource(name = "jdbcTemplate")
private JdbcTemplate jdbcTemplate;
```

### 7.3 数据库连接失败

**错误**：`rawConn is null` 或连接超时

**原因**：JDBC URL 格式错误

**解决**：
```properties
# ❌ 错误：多了一个斜杠
url=jdbc:/mysql://localhost:3306/spring_learn

# ✅ 正确
url=jdbc:mysql://localhost:3306/spring_learn
```

### 7.4 参数顺序错误

**错误**：`Data truncation: Truncated incorrect DOUBLE value: 'act-001'`

**原因**：SQL 参数顺序与占位符不匹配

**解决**：
```java
// SQL: update t_act set balance=? where actno=?
// ❌ 错误：参数顺序不对
jdbcTemplate.update(sql, account.getActno(), account.getBalance());

// ✅ 正确：balance 在前，actno 在后
jdbcTemplate.update(sql, account.getBalance(), account.getActno());
```

### 7.5 缺少默认构造函数

**错误**：`No default constructor found`

**原因**：`BeanPropertyRowMapper` 需要默认构造函数创建对象

**解决**：为实体类添加无参构造函数
```java
public class Account {
    // ✅ 添加默认构造函数
    public Account() {}
    
    public Account(String actno, double balance) {
        this.actno = actno;
        this.balance = balance;
    }
}
```

---

## 八、本章知识点总结

### 8.1 核心概念

- ✅ 事务的 ACID 特性
- ✅ 声明式事务管理
- ✅ @Transactional 注解使用
- ✅ 事务传播行为（7 种）
- ✅ 事务隔离级别（5 种）
- ✅ 事务属性配置（timeout、readOnly、rollbackFor）

### 8.2 配置方式

- ✅ XML 配置事务管理器 + `<tx:annotation-driven>`
- ✅ Java 配置类 + `@EnableTransactionManagement`

### 8.3 最佳实践

- ✅ 使用接口类型接收 Bean
- ✅ 查询操作使用 readOnly = true
- ✅ 明确指定 rollbackFor
- ✅ 合理设置事务传播行为

---

## 九、代码结构

```
Spring13_Infect/
├── src/main/java/
│   ├── Steps1/              # 事务管理入门 + 传播行为
│   │   ├── pojo/Account.java
│   │   ├── dao/AccountDao.java
│   │   ├── dao/impl/AccountDaoImpl.java
│   │   ├── service/AccountService.java
│   │   ├── service/impl/AccountServiceImpl.java
│   │   └── service/impl/AccountServiceImpl2.java
│   ├── Steps2/              # 隔离级别 + 事务属性
│   │   ├── pojo/Steps2_Account.java
│   │   ├── dao/Steps2_AccountDao.java
│   │   ├── dao/impl/Steps2_AccountDaoImpl.java
│   │   ├── service/Steps2_AccountService.java
│   │   ├── service/impl/Steps2_AccountServiceImpl.java
│   │   ├── service/impl/Steps2_IsolationService1.java
│   │   └── service/impl/Steps2_IsolationService2.java
│   └── Steps3/              # 基于注解的配置
│       └── Steps3_Config.java
├── src/main/resources/
│   ├── Steps1.xml
│   └── Steps2.xml
└── src/test/java/
    ├── Steps1.java
    ├── Steps2.java
    └── Steps3.java
```

---

## 十、学习建议

1. **理解事务传播**：重点掌握 REQUIRED 和 REQUIRES_NEW 的区别
2. **实践隔离级别**：通过并发场景理解不同隔离级别的效果
3. **掌握配置方式**：XML 和注解两种方式都要熟悉
4. **注意常见陷阱**：接口类型、参数顺序、默认构造函数等

---

**下一章**：Spring14_SpringMVC（Spring MVC 框架入门）
