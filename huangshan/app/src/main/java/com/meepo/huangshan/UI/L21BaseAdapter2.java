package com.meepo.huangshan.UI;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.meepo.huangshan.R;
import com.meepo.huangshan.UI.CardAdapter.CardAdapter;
import com.meepo.huangshan.bean.L18Card;
import com.meepo.huangshan.bean.L18CardArmsCard;
import com.meepo.huangshan.bean.L18CardAttackspellCardSpellCard;
import com.meepo.huangshan.bean.L18CardEffectspellCard;
import com.meepo.huangshan.bean.L18cardMinionCard;

import java.util.ArrayList;
import java.util.Iterator;

public class L21BaseAdapter2 extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    private ListView mLV;
    private ArrayList<L18Card> mData = new ArrayList<>();
    private CardAdapter mCardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l21_base_adapter2);

        initViews();
        initData();
    }

    public void initData() {
        L18CardEffectspellCard cardfXM = new L18CardEffectspellCard("弃暗投明", 2, "将自己的所有牌换为另一职业的牌，并且费用-1");
        L18CardAttackspellCardSpellCard cardfire = new L18CardAttackspellCardSpellCard("火球术", 4, 6);
        L18cardMinionCard cardfish = new L18cardMinionCard("小鱼人", 2, 2, 1);
        L18cardMinionCard cardsylvanas = new L18cardMinionCard("希尔瓦娜斯", 5, 5, 3);
        L18CardArmsCard cardaxe = new L18CardArmsCard("奥金斧", 5, 5, 2);
        L18CardAttackspellCardSpellCard cardfire2 = new L18CardAttackspellCardSpellCard("炎爆术", 10, 10);
        L18cardMinionCard cardfish2 = new L18cardMinionCard("小鱼人", 2, 2, 1);
        L18CardArmsCard cardsword = new L18CardArmsCard("真银圣剑", 4, 4, 2);
        L18cardMinionCard cardfoordring = new L18cardMinionCard("提里奥弗丁", 8, 6, 6);
        L18cardMinionCard cardkaelthas = new L18cardMinionCard("凯尔萨斯", 5, 3, 5);
        L18cardMinionCard cardfish3 = new L18cardMinionCard("小鱼人", 2, 2, 1);

        mData.add(cardfXM);
        mData.add(cardfire);
        mData.add(cardfish);
        mData.add(cardsylvanas);
        mData.add(cardfire2);
        mData.add(cardfish2);
        mData.add(cardsword);
        mData.add(cardfoordring);
        mData.add(cardkaelthas);
        mData.add(cardfish3);
        mData.add(cardaxe);

        sort();


        mCardAdapter = new CardAdapter(this, mData);
        mLV.setAdapter(mCardAdapter);
    }

    //    给卡牌分个类
    private void sort() {
        ArrayList<L18Card> cards = new ArrayList<>();
        Class[] classes = new Class[4];
        classes[0] = L18CardAttackspellCardSpellCard.class;
        classes[1] = L18cardMinionCard.class;
        classes[2] = L18CardEffectspellCard.class;
        classes[3] = L18CardArmsCard.class;
        for (int i = 0; i < classes.length; i++) {
//            创建一个迭代器，把mdata放进去
//            用两个循环来判断当前的class类型
//            如果符合某类型，就放进新数组中并且删掉迭代器中的那一项

            Iterator<L18Card> iterator = mData.iterator();
            while (iterator.hasNext()) {
                L18Card card = iterator.next();
                if (classes[i] == L18cardMinionCard.class && card instanceof L18cardMinionCard) {
                    cards.add(card);
                    iterator.remove();
                }
                if (classes[i] == L18CardAttackspellCardSpellCard.class && card instanceof L18CardAttackspellCardSpellCard) {
                    cards.add(card);
                    iterator.remove();
                }
                if (classes[i] == L18CardEffectspellCard.class && card instanceof L18CardEffectspellCard) {
                    cards.add(card);
                    iterator.remove();
                }
                if (classes[i] == L18CardArmsCard.class && card instanceof L18CardArmsCard) {
                    cards.add(card);
                    iterator.remove();
                }
            }
        }
        mData = cards;
    }


    public void initViews() {
        mLV = (ListView) findViewById(R.id.L21_lv);

        //        接口的三种实现
//        1. 建一个接口的实现类
//        mListView.setOnItemClickListener(new OnCardClickListener());
//        2. 实现一个接口的匿名内部类
//        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//                CardL18 card = (CardL18) adapterView.getItemAtPosition(position);
//                String content = card.getName();
//                Toast.makeText(L20And21BaseAdapterActivity.this, content, Toast.LENGTH_SHORT).show();
//            }
//        });
//        3. 让当前类直接实现接口

//        建立两个监听器
        mLV.setOnItemClickListener(this);
        mLV.setOnItemLongClickListener(this);

        // 假如有以下判断，都满足，这就是 JAVA 中的【多态】
//        if (this instanceof AdapterView.OnItemClickListener) {
//        }
//        if (this instanceof AppCompatActivity) {
//        }


    }

    //        直接实现接口如下
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        L18Card card = (L18Card) adapterView.getItemAtPosition(position);  //根据点击某项，实例化一个card
        String content = card.getName();
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long id) {
        L18Card card = (L18Card) adapterView.getItemAtPosition(position);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(card.getName()+"\n你想做什么");
        //建立一个数组，在双引号中填写内容，split方法可根据分隔符来吧一个string分隔成一个数组
        String[] items = "添加到收藏 删除".split(" ");
        //建立一个对话框，并实现必要的方法
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                switch (which) {
                    case 0:
                        Toast.makeText(L21BaseAdapter2.this, "已添加", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        //建立一个数组列表的通知
                        // 内部类可以获取外部类的成员
                        // 如果获取外部的本地变量，那么外部变量需要添加 final 关键字
                        mData.remove(position);
                        mCardAdapter.notifyDataSetChanged();
                        break;
                }
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
        return false;
    }


    //    旧办法：利用匿名内部类，建立一个点击事件监听器
    private class OnCardClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//            String name = (String) adapterView.getItemAtPosition(position);
//            String content = name + " - " + position;
            L18Card card = (L18Card) adapterView.getItemAtPosition(position);
            String content = card.getName();
            Toast.makeText(L21BaseAdapter2.this, content, Toast.LENGTH_SHORT).show();
        }
    }
}



