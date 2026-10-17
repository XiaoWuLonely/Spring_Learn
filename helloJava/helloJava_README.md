# helloJava —— Java SE 基础练习

非 Maven 项目，直接用 IDEA 打开后运行 `src/` 下各类的 `main` 方法。

## 知识点总览

### 1. 基础语法

| 知识点                                          | 对应文件                                    |
| -------------------------------------------- | --------------------------------------- |
| 8 种基本数据类型与变量声明                               | `MyStu/First/variable.java`、`Main.java` |
| 隐式 widening / 显式 narrowing 类型转换              | `cs01/java001byte.java`                 |
| `final` 常量                                   | `cs01/java002const.java`                |
| 类型转换：`String.valueOf()`、`Integer.parseInt()` | `MyStu/First/ChangeType.java`           |

### 2. 流程控制

| 知识点 | 对应文件 |
|---|---|
| `if` / `else if` / `else`、三元运算符、`instanceof` | `cs01/java003if.java` |
| `while`、`do-while`、`for` 循环 | `cs01/java004loop.java` |
| `switch` / `case`（含 fall-through 演示） | `cs01/java005switch.java`、`MyStu/First/Switch.java` |
| `break` / `continue` | `cla/St250922.java` |
| 综合练习：出租车计费、星期查询 | `zy/Java251009_1.java`、`zy/Java251009_2.java` |

### 3. 数组

| 知识点 | 对应文件 |
|---|---|
| 一维数组：创建、遍历、求和、找最大值 | `cs01/java008Datatype.java`、`cs01/java012Array.java` |
| 二维数组 | `MyStu/First/Array.java`、`cs01/java012Array.java` |
| `Arrays.sort()`、`Arrays.toString()` | `MyStu/First/Array.java`、`cla/St250929.java` |
| 数组作为方法参数 | `cs01/java008Datatype.java` |
| 综合练习：数组转置、手机号脱敏 | `zy/Java251013.java` |

### 4. 字符串处理

| 知识点 | 对应文件 |
|---|---|
| `StringBuilder`：append / insert / delete | `cs01/java007StringBufferAndBuilder.java` |
| `StringBuffer`（线程安全版本） | `cs01/java007StringBufferAndBuilder.java` |
| `split()`、`replace()`、`toLowerCase()` | `zy/Java251013.java` |

### 5. 方法

| 知识点 | 对应文件 |
|---|---|
| 方法定义与调用 | `cs01/java013Function.java` |
| 构造器重载、`this` 关键字 | `MyStu/First/Overload.java` |
| 可变参数（varargs） | `cs01/java015Duotai.java` |

### 6. 面向对象

| 知识点 | 对应文件 |
|---|---|
| 类与对象、字段、构造器 | `MyStu/First/Class.java`、`cs01/Person.java` |
| `static` 静态成员 | `MyStu/First/Class.java`、`cla/St251017.java` |
| **封装**：private 字段、getter/setter、输入校验 | `cla/St251103FengZhuang.java`、`zy/Java20251103.java` |
| **继承**：`extends`、`super`、构造器链 | `MyStu/First/Extent.java`、`cs01/Java014JiChen.java`、`cla/St251031.java` |
| 方法重写 `@Override` | `MyStu/First/Extent.java`、`cs01/Java014JiChen.java` |
| **多态**：向上转型、方法重写、`instanceof`、向下转型 | `cs01/java015Duotai.java`、`cla/St251110DuoTai.java`、`cla/Ja251117/Demo10.java` |
| 字段隐藏 vs 方法重写 | `cla/Ja251117/Demo11.java` |
| **抽象类**：`abstract` 关键字 | `MyStu/First/Abstract.java`、`cla/Ja251117/Demo12.java` |
| **接口**：`implements`、多接口继承、接口常量 | `MyStu/First/Interface.java`、`cla/Ja251124/InterfaceJieKou.java` |
| 重写 `Object` 方法：`toString()`、`equals()`、`hashCode()` | `cla/St251103.java` |
| **匿名内部类** | `cla/Ja251128/Test.java` |
| 综合 OOP 练习：宠物喂食 | `zy/Java5/Java251114.java` |

### 7. 异常处理

| 知识点 | 对应文件 |
|---|---|
| Exception vs Error | `cs02/异常/chapt12/DemoException.java` |
| `try` / `catch` / `finally` | `cs02/异常/chapt12/DemoTryCatch.java` |
| `throw` 手动抛异常 | `cs02/异常/chapt12/DemoThrow.java` |
| `throws` 声明传播异常 | `cs02/异常/chapt12/DemoThrows.java` |
| Checked vs Unchecked 异常 | `cs02/异常/chapt12/DemoCheckedException.java`、`DemoUncheckedException.java` |
| 自定义异常（checked + unchecked） | `cs02/异常/chapt12/UserNotFoundException.java`、`PasswordWrongException.java` |
| 综合练习：登录模拟 | `cs02/异常/chapt12/DemoLogin.java` |
| 综合练习：三角形校验 | `cs02/异常/YiChang.java` |

### 8. 常用工具类

| 知识点 | 对应文件 |
|---|---|
| `Number` 包装类转换 | `cs01/java006NumberAndMath.java` |
| `Math` 方法：sin / cos / random / sqrt 等 | `cs01/java006NumberAndMath.java`、`cs02/异常/chapt13/DemoMath.java` |
| `Date`：构造、比较、时间差 | `cs02/异常/chapt13/DemoDate.java` |
| `SimpleDateFormat`：Date ↔ String | `cs02/异常/chapt13/Demo1SimpleDateFormat.java`、`Demo2SimpleDateFormat.java` |
| `Calendar`：取值、日期运算 | `cs02/异常/chapt13/Demo1Calendar.java`、`Demo2Calendar.java` |
| `LocalDate` / `LocalTime` / `LocalDateTime` / `ZonedDateTime` / `Instant` | `cs01/java009Date.java` |
| `Random`：种子、各种 next 方法 | `cs02/异常/chapt13/Demo1Random.java`、`Demo2Random.java` |
| `Integer` 包装类 | `cs02/异常/chapt13/DemoInteger.java` |
| `BigDecimal`：精确小数运算、舍入模式 | `cs02/异常/chapt13/DemoBigDecimal.java` |
| `BigInteger`：大整数运算 | `cs02/异常/chapt13/DemoBigInteger.java` |
| 枚举（Enum） | `cs02/异常/chapt13/Season.java`、`SeasonTest.java` |

### 9. I/O 与控制台输入

| 知识点 | 对应文件 |
|---|---|
| `BufferedReader` + `InputStreamReader` 读取控制台 | `cs01/java010StreamADFileADIO.java` |
| `Scanner`：`next()`、`nextLine()` | `cs01/java011Scanner.java` |

### 10. GUI（Swing）入门

| 知识点 | 对应文件 |
|---|---|
| `JFrame`、`JButton`、`ActionListener`（匿名内部类） | `cla/Ja251128/ButtonExample.java` |
