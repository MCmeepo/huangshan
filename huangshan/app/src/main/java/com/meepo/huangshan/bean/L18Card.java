package com.meepo.huangshan.bean;


public abstract class L18Card {
    protected String Name;
    protected int Cost;
    protected String Description;

    public void setName(String name){Name =name;}

    public void setCost(int cost){Cost =cost;}

    public void setDescription(String description){Description =description;}

    public String getName() {return Name;}

    public int getCost() {return Cost;}

    public String getDescription() {return Description;}

    public abstract String play();
}
