package com.meepo.huangshan.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.meepo.huangshan.R;
import com.meepo.huangshan.bean.L18CardArmsCard;
import com.meepo.huangshan.bean.L18CardAttackspellCardSpellCard;

import org.json.JSONArray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class L25Json extends AppCompatActivity {

    private TextView l25_tv;
    private L18CardAttackspellCardSpellCard mFire;
    String jsonStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l25_json);

        l25_tv = (TextView) findViewById(R.id.l25_tv);
        mFire = new L18CardAttackspellCardSpellCard("火球术", 4, 4);
    }

    //ToString方法：查看数据存放的地方，每次new出来的对象，虽然名字有可能一样，但是存储的地方都不一样；
    //在页面一开始new出来的对象，在页面结束的时候清除；方法中new出来的对象，在方法结束时清除
    public void invokeToString(View view) {
        L18CardAttackspellCardSpellCard Sweep = new L18CardAttackspellCardSpellCard("横扫", 4, 4);
        L18CardArmsCard Roarofblood = new L18CardArmsCard("血吼", 7, 7, 7);
        String content = mFire.toString() + "\n"
                + Sweep.toString() + "\n"
                + Roarofblood.toString() + "\n";
        l25_tv.setText(content);
    }


    //HashMap :  是一种键值对格式，可以通过key调取对应的数据
    public void invokeMap(View view) {
        //建立一个哈希map，规定泛型
        HashMap<String, String> cardMap = new HashMap<>();
        cardMap.put("name", "横扫");   //填数据的时候，按照泛型规定的去填，第一个数据是key，第二个是数据
        cardMap.put("cost", "4");
        cardMap.put("damage", "4");
        String name = cardMap.get("name");
        String cost = cardMap.get("cost");
        String damage = cardMap.get("damage");

        // 如何便利 Map ?
        // 通过 keySet 方法获取所有 key 的集合
        Set<String> keySet = cardMap.keySet();
        // 通过迭代器便利 keySet
        Iterator<String> iterator = keySet.iterator();
        String content = "cardMap: \n";   //建立一个临时的字符串，存储遍历出来的数据
        while (iterator.hasNext()) {       //如果还没读完所有的key则继续循环
            String key = iterator.next();
            // 通过 key 从 map 中获取 value
            content = content + " key: " + key + " value: " + cardMap.get(key) + "\n";
        }

        l25_tv.setText("map size: " + cardMap.size()    //map中元素的个数
                + "\nname: " + name
                + "\ncost: " + cost
                + "\ndamage: " + damage
                + "\nmap: " + cardMap.toString()        //通过tostring方法读出map中的数据
                + "\nmap by while: " + content);

//        // map 中的其他方法
//        cardMap.isEmpty();
//        if (cardMap.containsKey("name")) {
//            cardMap.get("name");
//        }
//        if (cardMap.containsValue("Hulk")) {
//        }

//        // 清空所有键值对
//        cardMap.clear();
        //清除某个键值对
//        cardMap.remove("name");
    }


    //如何把一个对象中的数据放入Json中；如何一个对象中的数据放入Json数组中
    public void buildJson(View view) {
        L18CardAttackspellCardSpellCard Sweep = new L18CardAttackspellCardSpellCard("横扫", 8, 8);
        L18CardAttackspellCardSpellCard Frostbolt = new L18CardAttackspellCardSpellCard("寒冰箭", 2, 3);

        JSONArray jsonArray = new JSONArray();
        jsonArray.put(Sweep.toJson());
        jsonArray.put(Frostbolt.toJson());
        jsonStr = jsonArray.toString();
        l25_tv.setText(jsonStr);
    }


    //如何读取一段Json
    public void parseJson(View view) {
        String jsonStr = "{\"damage\":4,\"cost\":4,\"name\":\"Fire\"}";
        L18CardAttackspellCardSpellCard Fire = L18CardAttackspellCardSpellCard.parse(jsonStr);
        l25_tv.setText("卡牌名： "+Fire.getName() + "\n消耗： "+Fire.getCost() +"\n伤害： "+ Fire.getDamage());
    }

}
