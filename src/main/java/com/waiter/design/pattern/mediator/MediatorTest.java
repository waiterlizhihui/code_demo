package com.waiter.design.pattern.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MediatorTest
 * @Description 中介者模式的代理示例
 * @Author lizhihui
 * @Date 2019/10/29 15:39
 * @Version 1.0
 */
abstract class Mediator {
    /**
     * 注册同事类
     *
     * @param colleague
     */
    public abstract void register(Colleague colleague);

    /**
     * 转发请求
     *
     * @param colleague
     */
    public abstract void relay(Colleague colleague);
}

class ConcreteMediator extends Mediator {
    private List<Colleague> colleagues = new ArrayList<>();

    @Override
    public void register(Colleague colleague) {
        if (!colleagues.contains(colleague)) {
            colleagues.add(colleague);
            colleague.setMediator(this);
        }
    }

    @Override
    public void relay(Colleague colleague) {
        for (Colleague colleague1 : colleagues) {
            if (!colleague1.equals(colleague)) {
                colleague1.receive();
            }
        }
    }
}

abstract class Colleague {
    protected Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void receive();

    public abstract void send();
}

class ConcreteColleague1 extends Colleague {
    @Override
    public void receive() {
        System.out.println("具体同事类1收到请求");
    }

    @Override
    public void send() {
        System.out.println("具体同事类1发生请求");
        //请中介者转发
        mediator.relay(this);
    }
}

class ConcreteColleague2 extends Colleague {
    @Override
    public void receive() {
        System.out.println("具体同事类2收到请求");
    }

    @Override
    public void send() {
        System.out.println("具体同事类2发生请求");
        //请中介者转发
        mediator.relay(this);
    }
}

public class MediatorTest {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        Colleague colleague1 = new ConcreteColleague1();
        Colleague colleague2 = new ConcreteColleague2();
        mediator.register(colleague1);
        mediator.register(colleague2);
        colleague1.send();
        colleague2.send();
    }
}
