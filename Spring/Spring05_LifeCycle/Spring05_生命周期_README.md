# Spring05_LifeCycle —— Bean 生命周期

> 完整追踪 Spring Bean 从创建到销毁的每一步

## 知识点

### Bean 生命周期完整流程

```
1. 构造函数          ← Spring 通过无参构造创建实例
       ↓
2. Setter 注入       ← 注入 <property> 配置的属性值
       ↓
3. Aware 回调        ← Spring 将框架级引用注入给 Bean
   ├─ BeanNameAware.setBeanName()         → Bean 得知自己的 id
   ├─ BeanClassLoaderAware.setBeanClassLoader() → Bean 得知加载器
   └─ BeanFactoryAware.setBeanFactory()   → Bean 获得 BeanFactory 引用
       ↓
4. BeanPostProcessor 前置处理  ← postProcessBeforeInitialization()
       ↓
5. 初始化回调
   ├─ InitializingBean.afterPropertiesSet()  ← 框架级接口回调
   └─ init-method="initBean"                 ← 用户自定义初始化方法
       ↓
6. BeanPostProcessor 后置处理  ← postProcessAfterInitialization()
       ↓
7. Bean 就绪，可以使用   ← getBean() 获取并使用
       ↓
8. 容器关闭，触发销毁
   ├─ DisposableBean.destroy()               ← 框架级接口回调
   └─ destroy-method="destroyBean"           ← 用户自定义销毁方法
```

### 关键概念

| 概念 | 说明 |
|---|---|
| **Aware 接口** | 让 Bean 感知容器能力（BeanName、BeanFactory、BeanClassLoader 等） |
| **BeanPostProcessor** | 对所有 Bean 的初始化过程进行拦截，分前置和后置两个钩子 |
| **InitializingBean** | 框架级初始化回调，在属性注入完成后执行 |
| **DisposableBean** | 框架级销毁回调，在容器关闭时执行 |
| **init-method / destroy-method** | 用户自定义的初始化和销毁方法，通过 XML 属性指定 |

### 注意事项

- `BeanPostProcessor` 作用于配置文件中 **所有** Bean，不仅限于某一个
- 必须 **手动关闭** Spring 容器（`context.close()`），销毁回调才会执行
- `BeanPostProcessor` 的前置处理在 `InitializingBean.afterPropertiesSet()` **之前**执行
- `BeanPostProcessor` 的后置处理在 `init-method` **之后**执行

## 入口

`src/test/java/Steps1_Action.java`
