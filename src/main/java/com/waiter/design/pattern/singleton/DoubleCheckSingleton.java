package com.waiter.design.pattern.singleton;

/**
 * @ClassName DoubleCheckSingleton
 * @Description 用双重校验锁实现单例模式，不能防止反序列化导致重新创建新的对象
 * @Author lizhihui
 * @Date 2019/10/12 15:09
 * @Version 1.0
 */
public class DoubleCheckSingleton {
    /**
     * 注意这里用volatile关键字禁止了重排序，原因如下：
     * JVM会对代码进行优化
     */
    private volatile static DoubleCheckSingleton instance;
    private DoubleCheckSingleton(){}
    public static DoubleCheckSingleton getInstance() {
        //第一次校验单例是否实例化
        if (instance == null) {
            //构造一个临界区
            synchronized (DoubleCheckSingleton.class) {
                //第二次校验，原因如下：
                //假设有两个线程A,B同时调用getInstance(),A与B同时通过了第一次校验，然后A先进入临界区，B在临界区外等待，
                // 如果不存在第二次校验，在A在临界区里实例化一个对象之后退出临界区，B进入临界区又会实例化一个对象，这就不满足单例模式了，所以需要进行第二次校验
                if (instance == null) {
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
}
