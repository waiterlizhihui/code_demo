结构型模式：适配器(Adapter)模式
一.定义与特点
1.定义：将一个类的接口转换成客户端希望的另外一个接口，使得原本由于接口不兼容而不能一起工作的那些类能够一起工作。适配器模式分为类接口类型模式和对象结构性模式两种，类结构模式耦合度高，
且要求程序员了解现有组件库中的相关组件的内部结构，所以应用相对比较少
2.优点：
·客户端可以通过适配器可以透明地调用目标接口
·复用了现存地类，程序员不需要修改原有代码而重用现有地适配器类
·其目标是将目标类和适配器类解耦，解决了目标类和适配器类接口不一致的问题

二.模式结构
适配器模式包含以下角色：
1.目标(Target)接口：当前系统业务所期待的接口，它可以是抽象类或接口
2.适配者(Adaptee)类：它是被访问和适配的现存组件库中的组件接口
3.适配器(Adapter)类：它是一个转换器，通过继承或引用适配者的对象，把适配者接口转换成目标接口，让客户端按照目标接口的格式访问适配者

三.适配器模式的适用场景
1.以前开发的系统存在满足新系统功能需求的类，但其接口同新系统的接口不一致
2.使用第三方提供的组件，但组件接口定义和自己要求的接口定义不同

四.适配器模式的扩展
1.适配器模式可以扩展为双向适配器模式，双向适配器类既可以把适配器接口转换成目标接口，也可以把目标接口转换成适配者接口

五.个人理解
1.适配器也属于代理模式的一种，不过功能更具体一些，它的功能就是用于接口的转换