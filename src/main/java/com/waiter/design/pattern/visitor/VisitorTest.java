package com.waiter.design.pattern.visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName VisitorTest
 * @Description 访问者模式代码示例
 * @Author lizhihui
 * @Date 2019/10/30 15:36
 * @Version 1.0
 */

/**
 * 抽象访问者类
 */
interface Visitor {
    void visit(ConcreteElementA element);

    void visit(ConcreteElementB element);
}

/**
 * 具体访问者A类
 */
class ConcreteVisitorA implements Visitor {
    @Override
    public void visit(ConcreteElementA element) {
        System.out.println("具体访问者A访问——>" + element.operationA());
    }

    @Override
    public void visit(ConcreteElementB element) {
        System.out.println("具体访问者A访问——>" + element.operationB());
    }
}

/**
 * 具体访问者B类
 */
class ConcreteVisitorB implements Visitor {
    @Override
    public void visit(ConcreteElementA element) {
        System.out.println("具体访问者B访问——>" + element.operationA());
    }

    @Override
    public void visit(ConcreteElementB element) {
        System.out.println("具体访问者A访问——>" + element.operationB());
    }
}

/**
 * 抽象元素类
 */
interface Element {
    void accept(Visitor visitor);
}

/**
 * 具体元素A类
 */
class ConcreteElementA implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String operationA() {
        return "具体元素A的操作";
    }
}

/**
 * 具体元素B类
 */
class ConcreteElementB implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String operationB() {
        return "具体元素B的操作";
    }
}

/**
 * 对象结构角色
 */
class ObjectStructure {
    private List<Element> list = new ArrayList<>();

    public void accept(Visitor visitor) {
        Iterator<Element> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next().accept(visitor);
        }
    }

    public void add(Element element) {
        list.add(element);
    }

    public void remove(Element element) {
        list.remove(element);
    }
}

public class VisitorTest {
    public static void main(String[] args) {
        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.add(new ConcreteElementA());
        objectStructure.add(new ConcreteElementB());
        Visitor visitor = new ConcreteVisitorA();
        objectStructure.accept(visitor);
        visitor = new ConcreteVisitorB();
        objectStructure.accept(visitor);
    }
}
