package com.waiter.design.pattern.decorator;

/**
 * @ClassName DecoratorTest
 * @Description 装饰模式的代码实现
 * @Author lizhihui
 * @Date 2019/10/22 14:08
 * @Version 1.0
 */

/**
 * 抽象构件
 */
interface Component {
    void operation();
}

/**
 * 具体构件
 */
class ConcreteComponent implements Component {
    public ConcreteComponent() {
        System.out.println("创建具体构件角色");
    }

    @Override
    public void operation() {
        System.out.println("调用具体构件角色的方法");
    }
}

/**
 * 抽象修饰(将抽象构件组合进来)
 */
class Decorator implements Component {
    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }
}

/**
 * 具体装饰角色，在这里可以对原始的抽象构件进行扩展
 */
class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(Component component) {
        super(component);
    }

    public void operation() {
        super.operation();
        addFunction();
    }

    public void addFunction() {
        System.out.println("为具体构件角色增加的额外功能");
    }
}

public class DecoratorTest {
    public static void main(String[] args) {
        //具有原始功能的类
        Component origin = new ConcreteComponent();
        origin.operation();

        //装饰过后的类
        Component decorator = new ConcreteDecorator(origin);
        decorator.operation();
    }
}
