package com.waiter.spring.pojo;

import org.springframework.beans.factory.*;

/**
 * @ClassName Car2
 * @Description TOOD
 * @Author lizhihui
 * @Date 2019/9/9 16:04
 * @Version 1.0
 */
public class Car2 implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {
    private String brand;
    private String color;
    private int speed;

    private BeanFactory beanFactory;
    private String beanName;

    public Car2() {
        System.out.println("调用Car2构造函数");
    }

    //BeanFactoryAware接口的方法，实现之后bean可以获取beanFactory实例
    public void setBeanFactory(BeanFactory beanFactory) {
        System.out.println("调用BeanFactoryAware.setBeanFactory()");
        this.beanFactory = beanFactory;
    }

    //BeanNameAware接口的方法，实现之后可以设置beanName
    public void setBeanName(String beanName) {
        System.out.println("调用BeanNameAware.setBeanName()");
        this.beanName = beanName;
    }

    //InitializingBean接口的方法，在Bean属性实例化完成后调用
    public void afterPropertiesSet() {
        System.out.println("调用InitializingBean.afterPropertiesSet()");
    }

    //DisposableBean接口的方法，在Bean销毁之后调用
    public void destroy() {
        System.out.println("调用DisposableBean.destory");
    }

    public void myInit() {
        System.out.println("调用init-method所指定的myInit()");
        this.speed = 250;
    }

    public void myDestory() {
        System.out.println("调用destory-method所指定的myDestroy()");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        System.out.println("设置brand属性");
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", speed=" + speed +
                '}';
    }
}
