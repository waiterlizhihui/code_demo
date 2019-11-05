行为型模式：中介者(Mediator)模式
一.定义与特点
1.定义：定义一个中介对象来封装一系列对象之间地交互，使原有对象之间地耦合松散，且可以独立地改变它们之间的交互。中介模式又叫调停模式，它是迪米特法则的典型应用
2.优点：
·降低了对象之间的耦合性，使得对象易于独立地被复用
·将对象间的一对多关联转变为一对一的关联，提高系统的灵活性，使得系统易于维护和扩展
3.缺点
·当同事类(有交互关系的类)太多时，中介者的职责将很大，它会变得复杂而庞大，以至于系统难以维护

二.模式结构
中介者模式包括以下角色
1.抽象中介者(Mediator)角色：它是中介者的接口，提高了同事对象注册与转发同事对象信息的抽象方法
2.具体中介者(Concrete Mediator)角色：实现中介者接口，定义一个List来管理同事对象，协调各个同事对象之间的交互关系，因此它依赖于同事角色
3.抽象同事类(Colleague)角色：定义同事类的接口，保存中介者对象，提高同事对象交互的抽象方法，实现所有相互影响的同事类的公共功能
4.具体同事类(Concrete Colleague)角色：是抽象同事类的实现者，当需要与其他同事对象交互时，由中介者对象负责后续的交互

三.中介者模式的适用场景
1.当对象之间存在复杂的网状关系而导致依赖关系混乱且难以复用时
2.当想创建一个运行于多个类之间的对象，又不想生成新子类时

四.中介者模式的扩展
在实际开发中，通常采用以下两种方法来简化中介者模式，使开发变得更简单
1.不定义中介者接口，把具体中介者对象实现称为单例
2.同事对象不持有中介者，而是在需要的时候直接中介者对象并调用

五.个人疑问
1.这个和代理模式有什么区别？这不也相当于在同事对象之间实现了一层代理吗？