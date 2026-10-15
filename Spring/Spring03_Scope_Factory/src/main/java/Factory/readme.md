# 工厂方法模式:Factory Method Pattern

## 1. 工厂方法模式可以解决简单工厂模式当中的OCP问题。

怎么解决的?一个工厂对应生产一种产品。
这样工厂就不是全能类了,不是上帝类了。
另外,也可以符合OCP原则。


## 2. 工厂方法模式中的角色:

* 抽象产品角色 Weapon
* 具体产品角色 Dagger Gun
* 抽象工厂角色 WeaponFactory
* 具体工厂角色 DaggerFactory GunFactory