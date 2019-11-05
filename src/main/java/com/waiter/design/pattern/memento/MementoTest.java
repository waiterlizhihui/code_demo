package com.waiter.design.pattern.memento;

/**
 * @ClassName MementoTest
 * @Description 备忘录模式代码示例
 * @Author lizhihui
 * @Date 2019/10/30 16:29
 * @Version 1.0
 */

/**
 * 备忘录
 */
class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

/**
 * 发起人
 */
class Originator {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento createMemento() {
        return new Memento(state);
    }

    public void restoreMemento(Memento memento) {
        this.setState(memento.getState());
    }
}

/**
 * 管理者
 */
class Caretaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}

public class MementoTest {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();
        originator.setState("S0");
        System.out.println("初始状态:" + originator.getState());
        //保存状态
        caretaker.setMemento(originator.createMemento());
        originator.setState("S1");
        System.out.println("新的状态:" + originator.getState());
        originator.restoreMemento(caretaker.getMemento());
        System.out.println("恢复状态:" + originator.getState());
    }
}
