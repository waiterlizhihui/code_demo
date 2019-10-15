package com.waiter.thread;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName SimpleThreadLocal
 * @Description 自己实现简单的ThreadLocal
 * @Author lizhihui
 * @Date 2019/9/16 15:17
 * @Version 1.0
 */
public class SimpleThreadLocal {
    private Map valueMap = Collections.synchronizedMap(new HashMap<>());

    public void set(Object newValue) {
        valueMap.put(Thread.currentThread(), newValue);
    }

    public Object get() {
        Thread currentThread = Thread.currentThread();
        Object o = valueMap.get(currentThread);
        if (o == null && valueMap.containsKey(currentThread)) {
            o = initialValue();
            valueMap.put(currentThread, o);
        }
        return o;
    }

    public void remove() {
        valueMap.remove(Thread.currentThread());
    }

    public Object initialValue() {
        return null;
    }

    public static void main(String[] args) {
        SimpleThreadLocal simpleThreadLocal = new SimpleThreadLocal();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable(){
                @Override
                public void run() {
                    simpleThreadLocal.set(Thread.currentThread().getId());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程:"+Thread.currentThread().getId() + "的ID为:" + simpleThreadLocal.get());
                }
            }).start();
        }
    }
}
