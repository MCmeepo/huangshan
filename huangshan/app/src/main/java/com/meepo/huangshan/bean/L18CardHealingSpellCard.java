package com.meepo.huangshan.bean;

/**
 * Created by meepo on 2017/3/5.
 */

public class L18CardHealingSpellCard extends L18CardSpellCard {
    protected int Bloodreturnvalue;
    public String PlyaEffect;

    public void setBloodreturnvalue(int bloodreturnvalue) {
        Bloodreturnvalue = bloodreturnvalue;
    }

    public int getBloodreturnvalue() {
        return Bloodreturnvalue;
    }

    public String getPlyaEffect() {
        return PlyaEffect;
    }

    @Override
    public String play() {
        PlyaEffect = "你使用了一张[" + getName() + "]" + "治疗自己" + getBloodreturnvalue() + "点血量。";
        return PlyaEffect;
    }
}
