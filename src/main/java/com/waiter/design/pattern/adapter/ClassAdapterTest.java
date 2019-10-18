package com.waiter.design.pattern.adapter;

/**
 * @ClassName ClassAdaterTest
 * @Description 类适配器模式
 * @Author lizhihui
 * @Date 2019/10/17 11:50
 * @Version 1.0
 */
interface Target {
    void request();
}

class Adaptee {
    public void specificRequest() {
        System.out.println("适配器中的业务代码被调用!");
    }
}

class ClassAdapter extends Adaptee implements Target {
    @Override
    public void request() {
        specificRequest();
    }
}

public class ClassAdaterTest {
    public static void main(String[] args) {
        Target target = new ClassAdapter();
        target.request();
    }
}
