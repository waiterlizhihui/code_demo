package com.waiter.design.pattern.protype;

/**
 * @ClassName Prototype
 * @Description 原型模式代码示例
 * @Author lizhihui
 * @Date 2019/10/15 18:59
 * @Version 1.0
 */
class Prototype implements Cloneable{
    Prototype(){
        System.out.println("具体原型创建成功！");
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        System.out.println("具体原型复制成功！");
        return super.clone();
    }
}

public class PrototypeTest {
    public static  void main(String[] args) throws CloneNotSupportedException {
        Prototype prototype = new Prototype();
        Prototype prototypeClone = (Prototype) prototype.clone();
        System.out.println("prototype ==  prototypeClone:" + (prototype == prototypeClone));
    }
}
