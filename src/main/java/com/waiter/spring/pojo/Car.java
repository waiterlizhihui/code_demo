package com.waiter.spring.pojo;

/**
 * @ClassName Car
 * @Description TOOD
 * @Author lizhihui
 * @Date 2019/9/9 15:22
 * @Version 1.0
 */
public class Car {
    private String brand;
    private String color;
    private int speed;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
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
