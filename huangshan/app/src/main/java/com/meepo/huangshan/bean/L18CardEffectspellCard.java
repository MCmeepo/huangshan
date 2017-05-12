package com.meepo.huangshan.bean;


public class L18CardEffectspellCard extends L18CardSpellCard {
    protected String Effect;
    public String PlyaEffect;

    public  L18CardEffectspellCard(String name,int cost,String effect){
        setName(name);
        setCost(cost);
        setEffect(effect);
    }

    public void setEffect(String effect) {
        Effect = effect;
    }

    public String getEffect() {
        return Effect;
    }

    public String getPlyaEffect() {return PlyaEffect;}

    public String play() {
        PlyaEffect = "你使用了一张[" + getName() + "]" + "效果为" + getEffect();
        return PlyaEffect;
    }
}
