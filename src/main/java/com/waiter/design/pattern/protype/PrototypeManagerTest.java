package com.waiter.design.pattern.protype;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName PrototypeManagerTest
 * @Description TOOD
 * @Author lizhihui
 * @Date 2019/10/15 19:54
 * @Version 1.0
 */
interface Shape extends Cloneable {
    public Object clone();

    public void countArea();
}

class Circle implements Shape {
    @Override
    public Object clone() {
        Circle circle = null;
        try {
            circle = (Circle) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            System.out.println("拷贝失败");
        }
        return circle;
    }

    @Override
    public void countArea() {
        int r = 0;
        System.out.println("这是一个圆，请输入半径:");
        Scanner input = new Scanner(System.in);
        r = input.nextInt();
        System.out.println("圆的面积:" + 3.1415 * r * r);
    }
}

class Square implements Shape {
    @Override
    public Square clone() {
        Square b = null;
        try {
            b = (Square) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("拷贝正方形失败");
        }
        return b;
    }

    @Override
    public void countArea() {
        int a = 0;
        System.out.println("这是一个正方形，请输入边长：");
        Scanner input = new Scanner(System.in);
        a = input.nextInt();
        System.out.println("正方形的面积:" + a * a);
    }
}

class PrototypeManager {
    private Map<String, Shape> manager = new HashMap<>();

    public PrototypeManager() {
        manager.put("Circle", new Circle());
        manager.put("Square", new Square());
    }

    public void addShape(String shapeName, Shape shape) {
        manager.put(shapeName, shape);
    }

    public Shape getShape(String shapeName) {
        Shape temp = manager.get(shapeName);
        return (Shape) temp.clone();
    }
}

public class PrototypeManagerTest {
    public static void main(String[] args) {
        PrototypeManager prototypeManager = new PrototypeManager();
        Shape shape1 = prototypeManager.getShape("Circle");
        shape1.countArea();
        Shape shape2 = prototypeManager.getShape("Square");
        shape2.countArea();
    }
}
