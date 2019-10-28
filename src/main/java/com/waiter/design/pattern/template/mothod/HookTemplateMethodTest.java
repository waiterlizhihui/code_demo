package com.waiter.design.pattern.template.mothod;

/**
 * @ClassName HookTemplateMethodTest
 * @Description 具有钩子方法的模板方法代码示例
 * @Author lizhihui
 * @Date 2019/10/23 17:52
 * @Version 1.0
 */
abstract class HookAbstractClass {
    public void templateMethod() {
        abstractMethod1();
        hookMethod1();
        if (hookMethod2()) {
            specificMethod();
        }
        abstractMethod2();
    }

    public void specificMethod() {
        System.out.println("抽象类中的具体方法被调用");
    }

    public abstract void hookMethod1();

    public abstract boolean hookMethod2();

    public abstract void abstractMethod1();

    public abstract void abstractMethod2();
}

class HookConcreteClass extends HookAbstractClass {
    @Override
    public void hookMethod1() {

    }

    @Override
    public boolean hookMethod2() {
        return false;
    }

    @Override
    public void abstractMethod1() {
        System.out.println("抽象方法1的实现被调用");
    }

    @Override
    public void abstractMethod2() {
        System.out.println("抽象方法2的实现被调用");
    }
}

public class HookTemplateMethodTest {
    public static void main(String[] args) {
        HookAbstractClass hookAbstractClass = new HookConcreteClass();
        hookAbstractClass.templateMethod();
    }
}
