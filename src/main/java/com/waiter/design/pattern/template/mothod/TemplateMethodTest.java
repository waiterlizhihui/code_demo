package com.waiter.design.pattern.template.mothod;

/**
 * @ClassName TemplateMethodTest
 * @Description TOOD
 * @Author lizhihui
 * @Date 2019/10/23 17:33
 * @Version 1.0
 */

/**
 * 抽象类
 */
abstract class AbstractClass {
    /**
     * 模板方法
     */
    public void templateMethod() {
        specificMethod();
        abstractMethod1();
        abstractMethod2();
    }

    /**
     * 具体方法
     */
    public void specificMethod() {
        System.out.println("抽象类中的具体方法被调用");
    }

    /**
     * 抽象方法1
     */
    public abstract void abstractMethod1();

    /**
     * 抽象方法2
     */
    public abstract void abstractMethod2();
}

class ConcreteClass extends AbstractClass {
    @Override
    public void abstractMethod1() {
        System.out.println("抽象方法1的实现被调用");
    }

    @Override
    public void abstractMethod2() {
        System.out.println("抽象方法2的实现被调用");
    }
}

public class TemplateMethodTest {
    public static void main(String[] args) {
        AbstractClass abstractClass  = new ConcreteClass();
        abstractClass.templateMethod();
    }
}
