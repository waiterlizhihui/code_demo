package com.waiter.design.pattern.adapter;

/**
 * @ClassName TwoWayAdapterTest
 * @Description 双向适配器模式
 * @Author lizhihui
 * @Date 2019/10/21 18:50
 * @Version 1.0
 */
interface TwoWayTarget {
    void request();
}

interface TwoWayAdaptee {
    void specificRequest();
}

class TargetRealize implements TwoWayTarget {
    @Override
    public void request() {
        System.out.println("目标代码被调用");
    }
}

class AdapteeRealize implements TwoWayAdaptee {
    @Override
    public void specificRequest() {
        System.out.println("适配者代码被调用");
    }
}

class TwoWayAdapter implements TwoWayTarget, TwoWayAdaptee {
    private TwoWayTarget target;
    private TwoWayAdaptee adaptee;

    public TwoWayAdapter(TwoWayTarget target) {
        this.target = target;
    }

    public TwoWayAdapter(TwoWayAdaptee adaptee) {
        this.adaptee = adaptee;
    }

    /**
     * 将adaptee的接口转换成target的接口
     */
    @Override
    public void request() {
        adaptee.specificRequest();
    }

    /**
     * 将target的接口转换成adaptee的接口
     */
    @Override
    public void specificRequest() {
        target.request();
    }
}

public class TwoWayAdapterTest {
    public static void main(String[] args) {
        System.out.println("目标通过双向适配器访问适配者");
        TwoWayAdaptee adaptee = new AdapteeRealize();
        TwoWayTarget target =  new TwoWayAdapter(adaptee);
        target.request();
        System.out.println("===============================");
        System.out.println("适配者通过双向适配器访问目标");
        target = new TargetRealize();
        adaptee = new TwoWayAdapter(target);
        adaptee.specificRequest();
    }

}
