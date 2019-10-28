package com.waiter.design.pattern.command;

/**
 * @ClassName CommandTest
 * @Description TOOD
 * @Author lizhihui
 * @Date 2019/10/24 17:03
 * @Version 1.0
 */

/**
 * 抽象命令
 */
interface Command {
    void execute();
}

/**
 * 实现者
 */
class Receiver {
    public void action() {
        System.out.println("接收者的action()方法被调用");
    }
}

/**
 * 具体命令
 */
class ConcreteCommand implements Command {
    private Receiver receiver;

    public ConcreteCommand() {
        receiver = new Receiver();
    }

    @Override
    public void execute() {
        receiver.action();
    }
}

/**
 * 调用者
 */
class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void call() {
        System.out.println("调用者执行命令command");
        command.execute();
    }
}

public class CommandTest {
    public static void main(String[] args) {
        Command cmd = new ConcreteCommand();
        Invoker invoker = new Invoker(cmd);
        System.out.println("客户访问调用者的call()方法");
        invoker.call();
    }
}
