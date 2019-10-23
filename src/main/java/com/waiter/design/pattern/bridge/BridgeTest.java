package com.waiter.design.pattern.bridge;

/**
 * @ClassName BridgeTest
 * @Description 桥接模式代码实现
 * @Author lizhihui
 * @Date 2019/10/21 19:24
 * @Version 1.0
 */

/**
 * 实现化角色
 */
interface Implementor {
    void operationImpl();
}

/**
 * 具体实现化角色
 */
class ConcreteImplementorA implements Implementor {
    @Override
    public void operationImpl() {
        System.out.println("具体实现化A(Concrete Implementor)角色被访问");
    }
}

class ConcreteImlementorB implements Implementor{
    @Override
    public void operationImpl() {
        System.out.println("具体实现化B(Concrete Implementor)角色被访问");
    }
}

/**
 * 抽象化角色
 */
abstract class Abstraction {
    protected Implementor implementor;

    //抽象化角色将实现化角色进行组合
    protected Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    public abstract void opreation();
}

/**
 * 扩展抽象化角色
 */
class RefineAbstraction extends Abstraction {
    protected RefineAbstraction(Implementor implementor) {
        super(implementor);
    }

    @Override
    public void opreation() {
        System.out.println("扩展抽象化角色被访问");
        implementor.operationImpl();
    }
}

public class BridgeTest {
    public static void main(String[] args) {
        Implementor implementor = new ConcreteImplementorA();
        Abstraction abstraction = new RefineAbstraction(implementor);
        abstraction.opreation();
    }
}
