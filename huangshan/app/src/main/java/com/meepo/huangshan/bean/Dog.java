package com.meepo.huangshan.bean;

import android.content.Context;

public class Dog {
    public static int sFood = 0;

    private String mName;

    public Dog(String name) {
        sFood = 99;
        System.out.println("HS 创建了一只狗: " + name);
        this.mName = name;
    }

    static {
        System.out.println("HS Dog 类被加载了, sFood = " + sFood);
    }

    public static int getFood() {
        return sFood;
    }

    public static void setFood(int food) {
        sFood = food;
    }

    public String getName() {
        return mName;
    }

    public static Dog craeteStupidDog() {
        return new Dog("傻狗");
    }
}
