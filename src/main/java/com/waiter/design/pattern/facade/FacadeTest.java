package com.waiter.design.pattern.facade;

/**
 * @ClassName FacadeTest
 * @Description TOOD
 * @Author lizhihui
 * @Date 2019/10/22 14:48
 * @Version 1.0
 */
class Facade {
    private SubSystem1 subSystem1;
    private SubSystem2 subSystem2;
    private SubSystem3 subSystem3;

    public void method() {
        subSystem1.method1();
        subSystem2.method2();
        subSystem3.method3();
    }
}

class SubSystem1 {
    public void method1() {
        System.out.println("子系统1的方法method1被调用");
    }
}

class SubSystem2 {
    public void method2() {
        System.out.println("子系统2的方法method2被调用");
    }
}

class SubSystem3 {
    public void method3() {
        System.out.println("子系统3的方法method3被调用");
    }
}

public class FacadeTest {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.method();
    }
}
