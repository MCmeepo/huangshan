package com.meepo.huangshan.bean;

/**
 * Created by meepo on 2017/3/5.
 */

public class L18cardMinionCard extends L18Card implements L18CardAttackable {
    protected int Damage;
    protected int Blood;
    protected String Type;
    public String PlyaEffect;

    public L18cardMinionCard(String name,int cost,int damage,int blood){
        setName(name);
        setCost(cost);
        setDamage(damage);
        setBlood(blood);
    }

    public void setDamage(int damage) {
        Damage = damage;
    }

    public void setBlood(int blood) {
        Blood = blood;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getDamage() {
        return Damage;
    }

    public int getBlood() {
        return Blood;
    }

    public String getType() {
        return Type;
    }

    public String getPlyaEffect() {
        return PlyaEffect;
    }

    @Override
    public String play() {
        PlyaEffect = "你使用了一张[" + getName() + "]" + "对敌方造成了" + getDamage() + "点伤害。";
        return PlyaEffect;
    }

    @Override
    public String handleDamage() {
        L18CardEnemy.blood = L18CardEnemy.blood - L18cardMinionCard.this.getDamage();
        return PlyaEffect;
    }
}
