package com.waiter.design.pattern.adapter;

/**
 * @ClassName ObjectAdapterTest
 * @Description 对象适配器类
 * @Author lizhihui
 * @Date 2019/10/17 11:55
 * @Version 1.0
 */
class ObjectAdapter implements Target {
    private Adaptee adaptee;

    public ObjectAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}

public class ObjectAdapterTest {
    public static void main(String[] args) {
        System.out.println("对象适配器模式测试：");
        Adaptee adaptee = new Adaptee();
        //这样不是增加了适配者和适配器的耦合度吗?
        Target target = new ObjectAdapter(adaptee);
        target.request();
    }
}
