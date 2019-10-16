package com.waiter.design.pattern.factorymethod;

/**
 * @ClassName AbstractFactoryTest
 * @Description TOOD
 * @Author lizhihui
 * @Date 2019/10/16 15:24
 * @Version 1.0
 */

/**
 * 抽象产品
 */
interface Product {
    public void show();
}

/**
 * 具体产品1
 */
class ConcreteProduct1 implements Product {
    @Override
    public void show() {
        System.out.println("这是产品1");
    }
}

/**
 * 具体产品2
 */
class ConcreteProduct2 implements Product {
    @Override
    public void show() {
        System.out.println("这是产品2");
    }
}

/**
 * 抽象工厂
 */
interface AbstractFactory {
    Product newProduct();
}

/**
 * 具体工厂1，专门用于生成具体产品1
 */
class ConcreteFactory1 implements AbstractFactory {
    @Override
    public Product newProduct() {
        System.out.println("工厂1生成产品1");
        return new ConcreteProduct1();
    }
}

/**
 * 具体工厂2，专门用于生成具体产品2
 */
class ConcreteFactory2 implements AbstractFactory {
    @Override
    public Product newProduct() {
        System.out.println("工厂2生成产品2");
        return new ConcreteProduct2();
    }
}

public class FactoryMethodTest {
    public static Object getFactory(String factoryPath){
        Object factory = null;
        try {
            Class<?> clazz = Class.forName(factoryPath);
            factory = clazz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return factory;
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String factory1Path = "com.waiter.design.pattern.factorymethod.ConcreteFactory1";
        String factory2Path = "com.waiter.design.pattern.factorymethod.ConcreteFactory2";
        //根据传入的参数决定使用哪个工厂
        AbstractFactory abstractFactory = (AbstractFactory)getFactory(factory1Path);
        //有具体的工厂创建产品
        Product product = abstractFactory.newProduct();
        product.show();
        abstractFactory = (AbstractFactory)getFactory(factory2Path);
        product = abstractFactory.newProduct();
        product.show();
    }
}
