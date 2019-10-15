package com.waiter.spring;

import com.sun.org.apache.regexp.internal.RE;
import com.waiter.spring.pojo.Car2;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @ClassName MyBeanPostProcessor
 * @Description
 * @Author lizhihui
 * @Date 2019/9/9 16:27
 * @Version 1.0
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    //后处理器方法，实例化之前调用
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        if ("car2".equals(beanName)) {
            Car2 car2 = (Car2) bean;
            if (car2.getColor() == null) {
                System.out.println("BeanPostProcessor.postProcessBeforeInitialization()");
                System.out.println("汽车颜色为空，设置为黑色");
                car2.setColor("红色");
            }
        }
        return bean;
    }

    //后处理器方法，实例化完成值之后调用
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        if ("car2".equals(beanName)) {
            Car2 car2 = (Car2)bean;
            System.out.println("BeanPostProcessor.postProcessAfterInitialization()");
            System.out.println("将汽车的速度设置为1000");
            car2.setSpeed(1000);
        }
        return bean;
    }
}
