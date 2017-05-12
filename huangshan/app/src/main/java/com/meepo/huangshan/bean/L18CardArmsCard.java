package com.meepo.huangshan.bean;

/**
 * Created by meepo on 2017/3/5.
 */

public class L18CardArmsCard extends L18Card implements L18CardAttackable {
    protected int Damage;
    protected int Durable;
    public String PlyaEffect;

    public L18CardArmsCard(String name,int cost,int damage,int durable){
        setName(name);
        setCost(cost);
        setDamage(damage);
        setDurable(durable);
    }

    public void setDamage(int damage) {
        Damage = damage;
    }

    public void setDurable(int durable) {
        Durable = durable;
    }


    public int getDamage() {
        return Damage;
    }

    public int getDurable() {
        return Durable;
    }

    public String getPlyaEffect() {
        return PlyaEffect;
    }


    public String play() {
        PlyaEffect = "你使用了一张[" + getName() + "],效果为：造成"
                + getDamage() + "点伤害。";
        return PlyaEffect;
    }

    public String handleDamage() {
        L18CardEnemy.blood = L18CardEnemy.blood - L18CardArmsCard.this.getDamage();
        return PlyaEffect;
    }

}
