行为型模式：状态(State)模式
一.定义与特点
1.定义：对有状态的对象，把复杂的”判断逻辑“提取到不同的状态对象中，允许状态对象在其内部状态发生改变时改变其行为
2.优点：
·状态模式将特定状态相关的行为局部化到一个状态中，并且将不同状态的行为分割开来，满足”单一职责原则“
·减少对象间的相互依赖，将不同的状态引入独立的对象中会使得状态转换变得更加明确，且减少对象间得相互依赖
·有利于程序得扩展。通过定义新的子类很容易地增加新的状态和转换
3.缺点
·状态模式的使用必然会增加系统的类与对象的个数
·状态模式的结构与实现都较为复杂，如果使用不当会导致程序结构和代码的混乱

二.模式结构
状态模式主要包含以下角色：
1.环境(Context)角色：也称为上下文，它定义了客户感兴趣的接口，维护一个当前状态，并将与状态相关的操作委托给当前状态对象处理
2.抽象状态(State)角色：定义一个接口，用以封装环境对象中的特定状态所对应的行为
3.具体状态(Concrete State)角色：实现抽象状态所对应的行为

三.状态模式的适用场景
1.当一个对象的行为取决于它的状态，并且它必须在运行时根据状态改变它的行为时，就可以考虑使用状态模式
2.一个操作中含有庞大的分支结构，并且这些分支决定对象的状态时

四.状态模式的扩展
1.在有些情况下，可能有多个环境对象需要共享一组状态，这时需要引入享元模式，将这些具体状态对象放在集合中供程序共享

五.个人理解
1.状态模式就是根据状态对象的内部状态做出相应的行为，内部状态有多种含义，比如说对象的hashcode就可以当成一种状态(只是举例而已，不用真把hashcode当具体状态去用)