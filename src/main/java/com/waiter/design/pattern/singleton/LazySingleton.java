package com.waiter.design.pattern.singleton;

/**
 * @ClassName LazySingleton
 * @Description 懒汉模式的单例模式
 * @Author lizhihui
 * @Date 2019/10/12 14:04
 * @Version 1.0
 */
public class LazySingleton {
    private static LazySingleton instance;
    private LazySingleton(){}

    //线程不安全的方式获取实例
    public static LazySingleton getUnsafetyInstance(){
        if(instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }

    //线程安全的方式获取实例，但是不能防止反序列化导致重新创建新的对象
    public static synchronized LazySingleton getSafetyInstance(){
        if(instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
}



