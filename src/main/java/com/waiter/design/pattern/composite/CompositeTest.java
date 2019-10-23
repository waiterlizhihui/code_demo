package com.waiter.design.pattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CompositeTest
 * @Description 透明式组合模式代码示例
 * @Author lizhihui
 * @Date 2019/10/23 16:11
 * @Version 1.0
 */
interface Component {
    void add(Component component);

    void remove(Component component);

    Component getChild(int i);

    void operation();
}

class Leaf implements Component {
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void add(Component component) {
    }

    @Override
    public void remove(Component component) {
    }

    @Override
    public Component getChild(int i) {
        return null;
    }

    @Override
    public void operation() {
        System.out.println("树叶:" + name + "被访问");
    }
}

class Composite implements Component {
    private List<Component> children = new ArrayList();

    @Override
    public void add(Component component) {
        children.add(component);
    }

    @Override
    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public Component getChild(int i) {
        return children.get(i);
    }

    @Override
    public void operation() {
        for (Component component : children) {
            component.operation();
        }
    }
}

public class CompositeTest {
    public static void main(String[] args) {
        Component component1 = new Composite();
        Component component2 = new Composite();
        Component leaf1 = new Leaf("1");
        Component leaf2 = new Leaf("2");
        Component leaf3 = new Leaf("3");
        component1.add(leaf1);
        component1.add(component2);
        component2.add(leaf2);
        component2.add(leaf3);
        component1.operation();
    }
}
