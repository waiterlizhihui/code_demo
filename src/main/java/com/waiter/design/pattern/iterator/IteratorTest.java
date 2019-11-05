package com.waiter.design.pattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName IteratorTest
 * @Description 迭代器模式的代码示例
 * @Author lizhihui
 * @Date 2019/10/29 17:30
 * @Version 1.0
 */
interface Aggregate {
    void add(Object object);

    void remove(Object object);

    Iterator getIterator();
}

class ConcreteAggregate implements Aggregate {
    private List<Object> list = new ArrayList<>();

    @Override
    public void add(Object object) {
        list.add(object);
    }

    @Override
    public void remove(Object object) {
        list.remove(object);
    }

    @Override
    public Iterator getIterator() {
        return new ConcreteIterator(list);
    }

}

interface Iterator {
    Object first();

    Object next();

    boolean hasNext();
}

class ConcreteIterator implements Iterator {
    private List<Object> list;

    private int index = -1;

    public ConcreteIterator(List<Object> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        if (index < list.size() - 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object first() {
        index = 0;
        return list.get(index);
    }

    @Override
    public Object next() {
        Object object = null;
        if (this.hasNext()) {
            object = list.get(++index);
        }
        return object;
    }
}

public class IteratorTest {
    public static void main(String[] args) {
        Aggregate aggregate = new ConcreteAggregate();
        aggregate.add("中山大学");
        aggregate.add("华南理工");
        aggregate.add("北京大学");
        Iterator iterator = aggregate.getIterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            System.out.println(object.toString());
        }
        Object object = iterator.first();
        System.out.println(object.toString());
    }
}
