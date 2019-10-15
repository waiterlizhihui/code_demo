package com.waiter.spring;

import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

/**
 * @ClassName MyInstantiationAwareBeanPostProcessor
 * @Description TOOD
 * @Author lizhihui
 * @Date 2019/9/9 16:20
 * @Version 1.0
 */
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {
    //接口方法，在实例化bean前调用
    public Object postProcessBeforeInstantiation(Class beanClass, String beanName) {
        if ("car2".equals(beanName)) {
            System.out.println("postProcessBeforeInstantiation ");
        }
        return null;
    }

    //接口方法，在实例化bean后调用
    public boolean postProcessAfterInstantiation(Object bean, String beanName) {
        if ("car2".equals(beanName)) {
            System.out.println("postProcessAfterInstantiation");
        }
        return true;
    }

    //接口方法，在设置每个属性时调用
    public PropertyValues postProcessProperties(PropertyValues pvs, PropertyDescriptor pds, Object bean, String beanName) {
        if ("car2".equals(beanName)) {
            System.out.println("postProcessProperyValues");
        }
        return pvs;
    }
}
