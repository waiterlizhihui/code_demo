package com.waiter.design.pattern.interpreter;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName InterpreterTest
 * @Description 解释器模式的代码示例
 * @Author lizhihui
 * @Date 2019/10/30 18:53
 * @Version 1.0
 */
interface Expression {
    boolean interpret(String info);
}

class TerminalExpression implements Expression {
    private Set<String> set = new HashSet<>();

    public TerminalExpression(String[] data) {
        for (String s : data) {
            set.add(s);
        }
    }

    @Override
    public boolean interpret(String info) {
        if (set.contains(info)) {
            return true;
        }
        return false;
    }
}

class AndExpression implements Expression {
    private Expression city = null;
    private Expression person = null;

    public AndExpression(Expression city, Expression person) {
        this.city = city;
        this.person = person;
    }

    @Override
    public boolean interpret(String info) {
        String[] s = info.split("的");
        return city.interpret(s[0]) && person.interpret(s[1]);
    }
}

class Context {
    private String[] citys = {"赣州", "深圳"};
    private String[] persons = {"老人", "妇女", "儿童"};
    private Expression cityPerson;

    public Context() {
        Expression city = new TerminalExpression(citys);
        Expression person = new TerminalExpression(persons);
        cityPerson = new AndExpression(city, person);
    }

    public void freeRids(String info) {
        boolean ok = cityPerson.interpret(info);
        if (ok) {
            System.out.println("您是" + info + ",您本次乘车免费！");
        } else {
            System.out.println(info + ",您不是免费人员，本次乘车扣费2元");
        }
    }
}

public class InterpreterTest {
    public static void main(String[] args) {
        Context bus = new Context();
        bus.freeRids("赣州的老人");
        bus.freeRids("赣州的年轻人");
        bus.freeRids("深圳的妇女");
        bus.freeRids("深圳的儿童");
        bus.freeRids("山东的儿童");
    }
}
