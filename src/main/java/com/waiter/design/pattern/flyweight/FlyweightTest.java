package com.waiter.design.pattern.flyweight;

import com.sun.org.apache.regexp.internal.RE;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName FlyweightTest
 * @Description 享元模式代码示例
 * @Author lizhihui
 * @Date 2019/10/22 15:29
 * @Version 1.0
 */
class UnsharableConcreteFlyweight {
    private String info;

    public UnsharableConcreteFlyweight(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}

/**
 * 抽象享元
 */
interface Flyweight {
    /**
     * 将非享元以参数的形式传入
     * @param state
     */
    void operation(UnsharableConcreteFlyweight state);
}

/**
 * 具体享元
 */
class ConcreteFlyweight implements Flyweight {
    String key;

    public ConcreteFlyweight(String key) {
        this.key = key;
        System.out.println("具体享元" + key + "被创建");
    }

    @Override
    public void operation(UnsharableConcreteFlyweight outState) {
        System.out.println("具体享元" + key + "被调用");
        System.out.println("非享元信息是:" + outState.getInfo());
    }
}

class FlyweightFactory {
    private Map<String, Flyweight> flyweightMap = new HashMap<>();

    public Flyweight getFlyweight(String key) {
        Flyweight flyweight = flyweightMap.get(key);
        if (flyweight != null) {
            System.out.println("具体享元" + key + "已经存在，被成功获取！");
        } else {
            flyweight = new ConcreteFlyweight(key);
            flyweightMap.put(key,flyweight);
        }
        return flyweight;
    }
}

public class FlyweightTest {

    public static void main(String[] args) {
        FlyweightFactory flyweightFactory = new FlyweightFactory();
        Flyweight f1 = flyweightFactory.getFlyweight("a");
    }
}
