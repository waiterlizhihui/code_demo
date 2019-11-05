package com.waiter.design.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ObserverTest
 * @Description 观察者模式代码示例
 * @Author lizhihui
 * @Date 2019/10/29 14:44
 * @Version 1.0
 */

/**
 * 抽象主题
 */
abstract class Subject {
    protected List<Observer> observers = new ArrayList<>();

    /**
     * 注册观察者
     * @param observer
     */
    public void add(Observer observer) {
        observers.add(observer);
    }

    /**
     * 移除观察者
     * @param observer
     */
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    /**
     * 通知观察者方法
     */
    public abstract void notifyObserver();
}

/**
 * 具体主题
 */
class ConcreteSubject extends Subject {
    @Override
    public void notifyObserver() {
        System.out.println("具体目标发生改变");
        for (Observer observer : observers) {
            observer.response();
        }
    }
}

/**
 * 抽象观察者
 */
interface Observer {
    void response();
}

/**
 * 具体观察者1
 */
class ConcreteObserver1 implements Observer {
    @Override
    public void response() {
        System.out.println("具体观察者1作出反应");
    }
}

/**
 * 具体观察者2
 */
class ConcreteObserver2 implements Observer {
    @Override
    public void response() {
        System.out.println("具体观察者2做出反应");
    }
}

public class ObserverTest {
    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        Observer observer1 = new ConcreteObserver1();
        Observer observer2 = new ConcreteObserver2();
        subject.add(observer1);
        subject.add(observer2);
        subject.notifyObserver();
    }
}
