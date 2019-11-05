package com.waiter.design.pattern.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CompositeCommandTest
 * @Description 组合命令模式
 * @Author lizhihui
 * @Date 2019/10/24 17:36
 * @Version 1.0
 */

/**
 * 抽象命令
 */
interface AbstractCommand {
    void execute();
}

/**
 * 具体命令1
 */
class ConcreteCommand1 implements AbstractCommand {
    private CompositeReceiver receiver;

    public ConcreteCommand1() {
        receiver = new CompositeReceiver();
    }

    @Override
    public void execute() {
        receiver.action1();
    }
}

/**
 * 具体命令2
 */
class ConcreteCommand2 implements AbstractCommand {
    private CompositeReceiver receiver;

    public ConcreteCommand2() {
        receiver = new CompositeReceiver();
    }

    @Override
    public void execute() {
        receiver.action2();
    }
}

/**
 * 树枝构件：调用者
 */
class CompositeInvoker implements AbstractCommand {
    private List<AbstractCommand> children = new ArrayList<>();

    public void add(AbstractCommand abstractCommand) {
        children.add(abstractCommand);
    }

    public void remove(AbstractCommand abstractCommand) {
        children.remove(abstractCommand);
    }

    public AbstractCommand getChild(int i) {
        return children.get(i);
    }

    @Override
    public void execute() {
        for (Object o : children) {
            ((AbstractCommand)o).execute();
        }
    }
}

/**
 * 接收者
 */
class CompositeReceiver {
    public void action1() {
        System.out.println("接收者的action1()方法被调用");
    }

    public void action2() {
        System.out.println("接收者的action2()方法被调用");
    }
}

public class CompositeCommandTest {
    public static void main(String[] args) {
        AbstractCommand command1 = new ConcreteCommand1();
        AbstractCommand command2 = new ConcreteCommand2();
        CompositeInvoker compositeInvoker = new CompositeInvoker();
        compositeInvoker.add(command1);
        compositeInvoker.add(command2);
        System.out.println("客户访问调用者的execute()方法");
        compositeInvoker.execute();
    }
}
