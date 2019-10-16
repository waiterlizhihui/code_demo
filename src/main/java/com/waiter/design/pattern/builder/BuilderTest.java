package com.waiter.design.pattern.builder;

/**
 * @ClassName BuilderTest
 * @Description TOOD
 * @Author lizhihui
 * @Date 2019/10/16 17:31
 * @Version 1.0
 */

/**
 * 需要构建的产品
 */
class Product {
    private String partA;
    private String partB;
    private String partC;

    public String getPartA() {
        return partA;
    }

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public String getPartB() {
        return partB;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public String getPartC() {
        return partC;
    }

    public void setPartC(String partC) {
        this.partC = partC;
    }

    public void show() {
        System.out.println("partA:" + partA + " partB:" + partB + " partC:" + partC);
    }
}

/**
 * 抽象建造者
 */
abstract class Builder {
    protected Product product = new Product();

    public abstract void buildPartA();

    public abstract void buildPartB();

    public abstract void buildPartC();

    public Product getResult() {
        return product;
    }
}

/**
 * 具体建造者
 */
class ConcreteBuilder extends Builder {
    public void buildPartA() {
        product.setPartA("建造PartA");
    }

    public void buildPartB() {
        product.setPartA("建造PartB");
    }

    public void buildPartC() {
        product.setPartA("建造PartC");
    }
}

/**
 * 指挥者
 */
class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Product construct() {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getResult();
    }
}

public class BuilderTest {
    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        Product product = director.construct();
        product.show();
    }
}
