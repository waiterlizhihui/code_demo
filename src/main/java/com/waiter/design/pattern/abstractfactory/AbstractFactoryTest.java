package com.waiter.design.pattern.abstractfactory;

/**
 * @ClassName AbstractFactory
 * @Description TOOD
 * @Author lizhihui
 * @Date 2019/10/16 16:33
 * @Version 1.0
 */

/**
 * 抽象产品
 */
interface Product1 {
    void show();
}

interface Product2 {
    void show();
}

class ConcreteProduct1 implements Product1 {
    @Override
    public void show() {
        System.out.println("这是产品类型1的产品1");
    }
}

class ConcreteProduct2 implements Product2 {
    @Override
    public void show() {
        System.out.println("这是产品类型2的产品1");
    }
}

/**
 * 抽象工厂类
 */
interface AbstractFactory {
    Product1 newProduct1();

    Product2 newProduct2();
}

/**
 * 具体工厂1，专门用于生成具体产品1
 */
class ConcreteFactory1 implements AbstractFactory {
    @Override
    public Product1 newProduct1() {
        System.out.println("工厂1生成产品1");
        return new ConcreteProduct1();
    }

    @Override
    public Product2 newProduct2() {
        System.out.println("工厂1生成产品2");
        return new ConcreteProduct2();
    }
}

/**
 * 具体工厂2，专门用于生成具体产品2
 */
class ConcreteFactory2 implements AbstractFactory {
    @Override
    public Product1 newProduct1() {
        System.out.println("工厂2生成产品1");
        return new ConcreteProduct1();
    }

    @Override
    public Product2 newProduct2() {
        System.out.println("工厂2生成产品2");
        return new ConcreteProduct2();
    }
}

public class AbstractFactoryTest {
    public static void main(String[] args) {

    }
}
