package com.waiter.design.pattern.singleton;

/**
 * @ClassName Hungry
 * @Description 饿汉模式的单例模式
 * 饿汉模式的单例模式的有点是简单，但是不能拿实现懒加载，不能防止反序列化导致重新创建新的对象
 * @Author lizhihui
 * @Date 2019/10/12 14:34
 * @Version 1.0
 */
public class HungrySingleton {
    private  static final HungrySingleton instance = new HungrySingleton();
    private HungrySingleton(){}

    public static HungrySingleton getInstance(){
        return instance;
    }
}
