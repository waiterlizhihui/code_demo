package com.waiter.design.pattern.state;

/**
 * @ClassName StateTest
 * @Description TOOD
 * @Author lizhihui
 * @Date 2019/10/28 11:41
 * @Version 1.0
 */
class Context {
    private State state;

    //定义环境类的初始状态
    public Context() {
        this.state = new ConcreteStateA();
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void Handle() {
        state.Handle(this);
    }

}

abstract class State {
    public abstract void Handle(Context context);
}

class ConcreteStateA extends State {
    @Override
    public void Handle(Context context) {
        System.out.println("当前的状态是A");
        context.setState(new ConcreteStateB());
    }
}

class ConcreteStateB extends State {
    @Override
    public void Handle(Context context) {
        System.out.println("当前状态是B");
        context.setState(new ConcreteStateA());
    }
}

public class StateTest {
    public static void main(String[] args) {
        Context context = new Context();
        context.Handle();
        context.Handle();
        context.Handle();
        context.Handle();
    }
}
