package com.meepo.huangshan.bean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by meepo on 2017/3/5.
 */

public class L18CardAttackspellCardSpellCard extends L18CardSpellCard implements L18CardAttackable{
    private int Damage;

    public String PlyaEffect;

    public L18CardAttackspellCardSpellCard(String name,int cost,int damage){
        setName(name);
        setCost(cost);
        setDamage(damage);
    }

    public void setDamage(int damage) {Damage = damage;}

    public int getDamage() {return Damage;}

    public String getPlyaEffect() {return PlyaEffect;}

    public String play() {
        PlyaEffect = "你使用了一张[" + getName() + "],效果为：造成"
                + getDamage() + "点伤害。";
        return PlyaEffect;
    }

    public String handleDamage() {
        L18CardEnemy.blood = L18CardEnemy.blood - L18CardAttackspellCardSpellCard.this.getDamage();
        return PlyaEffect;
    }


    //把一个对象中的变量和变量的值放进Json类型的数据中
    public String toJson() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("name", getName());
            jsonObject.put("cost", getCost());
            jsonObject.put("damage", getDamage());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }


    //建立方法，传入一个String对象(内容为打包好的Json数据)，得到一个L18CardAttackspellCardSpellCard对象
    public static L18CardAttackspellCardSpellCard parse(String jsonStr) {
        L18CardAttackspellCardSpellCard attackspellCardSpellCard = null;
        try {
            //先建立一个JSONObject对象，传入String对象，利用JSONObject中的getsSring和getInt方法解析键,得到键中的数据
            JSONObject jsonObject = new JSONObject(jsonStr);
            String name = jsonObject.getString("name");
            int cost = jsonObject.getInt("cost");
            int damage = jsonObject.optInt("damage");
            //得到数据后，通过构造方法得到一个L18CardAttackspellCardSpellCard的对象并返回
            attackspellCardSpellCard = new L18CardAttackspellCardSpellCard(name, cost, damage);
        } catch (JSONException e) {
            e.printStackTrace();   //处理错误
        }
        return attackspellCardSpellCard;
    }


    // 建立方法，传入一个String对象(内容为打包好的Json数据，里面有多套键值对)，得到一个L18CardAttackspellCardSpellCard对象数组
    public static List<L18CardAttackspellCardSpellCard> parseList(String jsonStr) {
        ArrayList<L18CardAttackspellCardSpellCard> list = new ArrayList<>();
        try {
            //建立一个Json数组，传入Json数据，然后进行循环，每次循环把解析好的数据放入范型为L18CardAttackspellCardSpellCard的list中
           // 返回得到的list
            JSONArray jsonArray = new JSONArray(jsonStr);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.optJSONObject(i);
                L18CardAttackspellCardSpellCard cardL18 = parse(jsonObject.toString());
                list.add(cardL18);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }
}
