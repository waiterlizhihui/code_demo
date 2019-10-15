package com.waiter.spring;

import com.waiter.spring.pojo.Car;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * @ClassName BeanFactoryTest
 * @Description TOOD
 * @Author lizhihui
 * @Date 2019/9/9 15:22
 * @Version 1.0
 */
public class BeanFactoryTest {
    /**
     * 通过BeanFactory注入beans.xml里面配置好了的bean
     */
    @Test
    public void getBean() {
        //利用Resource接口加载配置文件
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resource = resolver.getResource("classpath:spring/beans.xml");
        System.out.println(resource.exists());

        //实例化一个BeanFactory并解析xml文件
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(resource);
        System.out.println("init BeanFactory");

        //通过BeanFactory注入bean
        Car car = factory.getBean("car1",Car.class);
        System.out.println("car bean is ready for use!");
        System.out.println(car);
    }
}
