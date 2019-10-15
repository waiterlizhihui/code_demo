package com.waiter.design.pattern.singleton;

/**
 * @ClassName StaticSingleton
 * @Description 静态内部类的方式实现单例模式
 * @Author lizhihui
 * @Date 2019/10/12 17:14
 * @Version 1.0
 */
public class StaticSingleton {
    private static class SingletonHolder {
        private static final StaticSingleton instance = new StaticSingleton();
    }

    private StaticSingleton() {
    }

    public static final StaticSingleton getInstance() {
        return SingletonHolder.instance;
    }
}
