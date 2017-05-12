package com.meepo.huangshan.bean;


public class L8_Player {

    //    定义属性,范围L8_Player
    private String name = "土土";
    private int age = 12;

    //方法：调用name,范围 public
    public String getName() {
        return name;
    }

    //方法：修改name,范围 public
    public void setName(String newName) {
        name = newName;
    }

    //方法：调用age,范围 public
    public int getAge() {
        return age;
    }

    //方法：修改age,范围 public
    public void setAge(int newAge) {
        age = newAge;
    }

}
