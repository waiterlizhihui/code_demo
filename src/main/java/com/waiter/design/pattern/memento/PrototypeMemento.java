package com.waiter.design.pattern.memento;

/**
 * @ClassName PrototypeMemento
 * @Description 原型模式与备忘录模式的结合，实现多状态备份
 * @Author lizhihui
 * @Date 2019/10/30 16:45
 * @Version 1.0
 */
class OriginatorPrototype implements Cloneable {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public OriginatorPrototype createMemento() {
        return this.clone();
    }

    public void restoreMemento(OriginatorPrototype originatorPrototype) {
        this.setState(originatorPrototype.getState());
    }

    public OriginatorPrototype clone() {
        try {
            return (OriginatorPrototype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}

class PrototypeCaretaker {
    private OriginatorPrototype originatorPrototype;

    public void setMemento(OriginatorPrototype originatorPrototype) {
        this.originatorPrototype = originatorPrototype;
    }

    public OriginatorPrototype getMemento() {
        return originatorPrototype;
    }
}

public class PrototypeMemento {
    public static void main(String[] args) {
        OriginatorPrototype originatorPrototype = new OriginatorPrototype();
        PrototypeCaretaker caretaker = new PrototypeCaretaker();
        originatorPrototype.setState("S0");
        System.out.println("初始状态:" + originatorPrototype.getState());
        //保存状态
        caretaker.setMemento(originatorPrototype.createMemento());
        originatorPrototype.setState("S1");
        System.out.println("新的状态:" + originatorPrototype.getState());
        //恢复状态
        originatorPrototype.restoreMemento(caretaker.getMemento());
        System.out.println("恢复状态:" + originatorPrototype.getState());
    }

}
