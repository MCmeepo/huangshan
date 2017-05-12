package com.meepo.huangshan.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.meepo.huangshan.R;
import com.meepo.huangshan.bean.L18Card;
import com.meepo.huangshan.bean.L18CardArmsCard;
import com.meepo.huangshan.bean.L18CardAttackable;
import com.meepo.huangshan.bean.L18CardAttackspellCardSpellCard;
import com.meepo.huangshan.bean.L18CardEffectspellCard;
import com.meepo.huangshan.bean.L18CardEnemy;
import com.meepo.huangshan.bean.L18CardHealingSpellCard;
import com.meepo.huangshan.bean.L18cardMinionCard;

public class L18test extends AppCompatActivity {
    public TextView tv_enemy;
    public TextView tv_player1card;
    public Button btn_play;
    public TextView tv_log;
    public String carddata = "手牌";
    public String newcarddata;
    public String log = "战斗日志：";
    public String newlog;

    public L18Card[] card = new L18Card[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l18test);

        initViews();
        makecard();
    }

    public void play(View view) {
        for (int i = 0; i < 5; i++) {
            newlog =  card[i].play();
            if (card[i] instanceof L18CardAttackable) {
                newlog =((L18CardAttackable) card[i]).handleDamage();
            }
            log = log + "\n" + newlog;
        }
        tv_enemy.setText("" + L18CardEnemy.blood);
        tv_log.setText(log);

    }

    public void makecard() {
        card[0] = new L18CardArmsCard("奥金斧", 5, 5, 2);
        card[0].setName("血吼");
        card[0].setCost(5);
//        card[0].getDescription();
        ((L18CardArmsCard) card[0]).setDamage(7);


        card[1] = new L18CardAttackspellCardSpellCard("奥金斧", 5, 5);
        card[1].setName("火球术");
        card[1].setCost(4);
        ((L18CardAttackspellCardSpellCard) card[1]).setDamage(6);
//        ((L18CardHealingSpellCard) card[2]).setDescription();

        card[2] = new L18CardHealingSpellCard();
        card[2].setName("治疗波");
        card[2].setCost(3);
        ((L18CardHealingSpellCard) card[2]).setBloodreturnvalue(5);
//        ((L18CardHealingSpellCard) card[2]).setDescription();

        card[3] = new L18cardMinionCard("奥金斧", 5, 5, 2);
        card[3].setName("火车王");
        card[3].setCost(6);
        ((L18cardMinionCard) card[3]).setBlood(3);
        ((L18cardMinionCard) card[3]).setDamage(6);
//        ((L18CardHealingSpellCard) card[2]).setDescription();

        card[4] = new L18CardEffectspellCard("弃暗投明", 2, "将自己的所有牌换为另一职业的牌，并且费用-1");
        card[4].setName("妖术");
        card[4].setCost(4);
        ((L18CardEffectspellCard) card[4]).setEffect("把对方变成了一只青蛙。");

        for (int i = 0; i < 5; i++) {
            newcarddata = card[i].getName() + " " + card[i].getCost();
            if (card[i] instanceof L18CardHealingSpellCard) {
                newcarddata = newcarddata + " 治疗量：" + ((L18CardHealingSpellCard) card[i]).getBloodreturnvalue();
            }
            if (card[i] instanceof L18CardAttackspellCardSpellCard) {
                newcarddata = newcarddata + " 伤害量：" + ((L18CardAttackspellCardSpellCard) card[i]).getDamage();
            }
            if (card[i] instanceof L18cardMinionCard) {
                newcarddata = newcarddata + " 攻击力：" + ((L18cardMinionCard) card[i]).getDamage() +
                        " 血量：" + ((L18cardMinionCard) card[i]).getBlood();
            }
            if (card[i] instanceof L18CardArmsCard) {
                newcarddata = newcarddata + " 攻击力：" + ((L18CardArmsCard) card[i]).getDamage() +
                        " 耐久度：" + ((L18CardArmsCard) card[i]).getDurable();
            }

            carddata = carddata + "\n" + newcarddata;
        }

        tv_player1card.setText(carddata);
    }

    public void initViews() {
        tv_enemy = (TextView) findViewById(R.id.L18test_tv_enemy);
        tv_player1card = (TextView) findViewById(R.id.L18test_tv_player1card);
        btn_play = (Button) findViewById(R.id.L18test_btn_play);
        tv_log = (TextView) findViewById(R.id.L18test_tv_log);

        tv_enemy.setText("" + L18CardEnemy.blood);
    }
}
