package com.waiter.spring;

import com.waiter.spring.pojo.Car2;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @ClassName BeanLifeCycle
 * @Description TOOD
 * @Author lizhihui
 * @Date 2019/9/9 16:36
 * @Version 1.0
 */
public class BeanLifeCycle {
    private static void LifeCycleInBeanFactory() {
        Resource resource = new ClassPathResource("spring/beans.xml");

        BeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((DefaultListableBeanFactory) beanFactory);
        reader.loadBeanDefinitions(resource);

        //注册MyBeanPostProcessor后处理器
        ((ConfigurableBeanFactory) beanFactory).addBeanPostProcessor(new MyBeanPostProcessor());
        //注册MyInstantiationAwareBeanPostProcessor后处理器
        ((ConfigurableBeanFactory) beanFactory).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());

        Car2 car2 = (Car2) beanFactory.getBean("car2");
        System.out.println(car2);
        car2.setColor("白色");

        //Singleton模式，实例化的Bean会被缓存起来，所以car2==car21为true
        Car2 car21 = (Car2) beanFactory.getBean("car2");
        System.out.println("car2==car21:" + (car2 == car21));

        //关闭容器
        ((DefaultListableBeanFactory) beanFactory).destroySingletons();
    }

    public static void main(String[] args) {
        LifeCycleInBeanFactory();
    }
}
