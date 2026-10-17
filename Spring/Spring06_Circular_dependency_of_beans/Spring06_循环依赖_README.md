# Spring06_Circular_dependency_of_beans —— 循环依赖

> 通过 Husband/Wife 场景验证循环依赖的三种场景

## 知识点

### 什么是循环依赖

Bean A 依赖 Bean B，Bean B 又依赖 Bean A，形成闭环。

### 场景总结

| 场景 | 作用域 | 注入方式 | 结果 |
|---|---|---|---|
| Step 1 | singleton + singleton | setter | **可以解决** |
| Step 1 变体 | prototype + prototype | setter | **无法解决**，抛出 `BeanCurrentlyInCreationException` |
| Step 2 | singleton + singleton | constructor | **无法解决**，抛出 `BeanCurrentlyInCreationException` |

### Step 1：Setter 注入 + Singleton（可解决）

Spring 通过 **三级缓存** 解决 singleton 作用域下的 setter 循环依赖：

```
创建 A → 实例化 A（暴露早期引用到三级缓存）
       → 填充属性 → 需要 B
                    → 创建 B → 实例化 B（暴露早期引用）
                              → 填充属性 → 需要 A → 从三级缓存获取 A 的早期引用 ✓
                              → B 初始化完成 ✓
       → A 拿到 B → A 初始化完成 ✓
```

**核心思想**：将 Bean 的"实例化"和"属性填充"拆成两个阶段。实例化后立即暴露早期引用（对象引用已存在，但属性还未赋值），让依赖方能拿到引用继续创建，从而打破循环等待。

### Step 1 变体：Prototype（无法解决）

Prototype 作用域下，每次 `getBean()` 都会创建新实例，不会缓存。因此没有"早期引用"可以复用，循环依赖无法打破。

### Step 2：Constructor 注入（无法解决）

构造器注入要求在 **实例化** 阶段就必须拿到依赖对象。但此时两个 Bean 都还没被实例化，无法暴露早期引用，三级缓存机制无从发挥作用。

### 核心结论

1. Spring **只能** 解决 **singleton + setter** 的循环依赖
2. **prototype** 作用域不缓存，无法解决
3. **构造器注入** 在实例化阶段就需要依赖，无法解决
4. 最佳实践：**在设计层面避免循环依赖**

## 入口

- Step 1（setter）：`src/test/java/Steps1_Action.java`
- Step 2（constructor）：`src/test/java/Steps2_Action.java`
