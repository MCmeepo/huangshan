package com.meepo.huangshan.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.meepo.huangshan.R;
import com.meepo.huangshan.UI.CardAdapter.CardAdapter;
import com.meepo.huangshan.bean.L18Card;
import com.meepo.huangshan.bean.L18CardArmsCard;
import com.meepo.huangshan.bean.L18CardAttackspellCardSpellCard;
import com.meepo.huangshan.bean.L18CardEffectspellCard;
import com.meepo.huangshan.bean.L18cardMinionCard;

import java.util.ArrayList;

public class L20BaseAdapter extends AppCompatActivity {

    private ListView mLV;
    private ArrayList<L18Card> mData = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l20_base_adapter);

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

        CardAdapter mCardAdapter = new CardAdapter(this, mData);
        mLV.setAdapter(mCardAdapter);
    }

    public void initViews() {
        mLV = (ListView) findViewById(R.id.L20_lv);
    }
}
