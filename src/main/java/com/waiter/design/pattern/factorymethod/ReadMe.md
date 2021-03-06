创建型模式：工厂方法(FactoyMethod)模式
一.定义：定义一个创建产品(被创建的对象被称作”产品“)对象的工厂接口，将产品对象的实际创建工作推迟到具体子工厂类(“即具体的工厂类”)当中，
这满足创建型模式中所要求的“创建于使用相分离”的特定。
如果要创建的产品不多，只要一个工厂类就可以完成，这种模式叫“简单工厂模式”，它不属于GoF的23种经典设计模式，它的缺点是增加新“产品”时会违背“开闭原则”
工厂方法模式是在简单工厂模式的基础上进一步抽象化，其好处是可以使系统在不修改原来代码的情况下引进新“产品”，即满足开闭原则
工厂方法模式具有以下特点：
·用户只需要知道具体工厂的名称就可以得到所需的产品，无需知道产品的具体创建过程
·在系统增加新的产品时，只需要添加具体产品类和对应的具体工厂类，无须对原工厂进行任何修改，满足开闭原则

二.模式结构
工厂方法模式包含以下角色：
1.抽象工厂(Abstract Factory)：提供创建产品的接口，调用者使用它访问具体工厂的工厂方法来创建产品
2.具体工厂(Concrete Factory)：主要时实现抽象工厂种的抽象方法，完成具体的产品的创建过程
3.抽象产品(Product)：定义产品的规范，描述产品的主要特性和功能
4.具体产品(Concrete Product)：实现了抽象产品角色所定义的接口，有具体工厂来创建，它同具体工厂一一对应

三.工厂方法模式的应用场景
1.使用者只知道创建产品的工厂名，而不知道具体的产品名
2.创建对象的任务由具体的子工厂完成，而抽象工厂只提供创建产品的接口
3.使用者只关注产品的使用，而不关心产品的创建细节

四.工厂方法模式的扩展
1.当需要生成的产品不多且不会增加、一个具体工厂类就可以完成任务时，可以删除抽象工厂类，这时工厂方法模式将退化到简单工厂模式

五.个人理解
1.简单工厂模式的核心思想就是将对象的创建与使用分开，但是这种模式有一种缺点就是对象和工厂完全绑定了，如果想要扩展工厂生成的对象的话要么修改工厂，
要么新创建一个工厂类创建新的对象，这就违反了设计模式的“开闭原则”(对扩展开放，对修改关闭)。而工厂方法模式则没有这个问题，工厂方法模式用抽象工厂类和抽象产品类将工厂和对象的关系进行绑定，
这个关系绑定好了之后在抽象工厂的基础上对工厂进行扩展，在抽象产品类的基础上对要生成的对象进行扩展
注意：使用抽象工厂模式生成的对象之间必须要有某种关系，如果是完全没有关系的对象，那完全没必要用抽象工厂，直接每种对象一个简单工厂就行了


