package com.meepo.huangshan.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.meepo.huangshan.R;

import java.util.Random;

public class chuangjianrenwu extends AppCompatActivity {
    int times = 0;

    int li = 0;
    int liliang;
    int mli = 0;

    int zhi = 0;
    int zhili;
    int mzhi = 0;

    int min = 0;
    int minjie;
    int mmin = 0;

    int hp = 0;
    int shengming;
    int mhp = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chuangjianrenwu);
    }

//    public void shuxing(View view) {
//        switch (times) {
//            case 1:
//                TextView tv_1 = (TextView) findViewById(R.id.cj_tv_1);
//                tv_1.setText("你童年曾经历过什么？");
//                break;
//            case 2:
//                TextView tv_2 = (TextView) findViewById(R.id.cj_tv_1);
//                tv_2.setText("如果国王正被围攻，你会。。");
//                break;
//            case 3:
//                TextView tv_3 = (TextView) findViewById(R.id.cj_tv_1);
//                tv_3.setText("你为何来到艾泽拉斯？");
//                break;
//            case 4:
//                TextView tv_4 = (TextView) findViewById(R.id.cj_tv_1);
//                tv_4.setText("如果你有盖世的力量，你会。。");
//                break;


//        }
//
//    }

    public void liliang(View view) {
        liliang = new Random().nextInt(20) + 80;
        mli = li * 50 + liliang;
        times = times + 1;
        li = li + 1;

        zhili = new Random().nextInt(20) + 80;
        mzhi = zhi * 50 + zhili;


        minjie = new Random().nextInt(20) + 80;
        mmin = min * 50 + minjie;


        shengming = new Random().nextInt(20) + 80;
        mhp = hp * 50 + shengming;


        switch (times) {
            case 1:
                Button btn__li_1 = (Button) findViewById(R.id.cj_btn_1);
                btn__li_1.setText("曾经是军人之子，钻研武学");
                Button btn__zhi_1 = (Button) findViewById(R.id.cj_btn_2);
                btn__zhi_1.setText("出身于贵族家庭，钻研知识");
                Button btn__min_1 = (Button) findViewById(R.id.cj_btn_3);
                btn__min_1.setText("曾经是孤独的猎人纵横山野");
                Button btn__hp_1 = (Button) findViewById(R.id.cj_btn_4);
                btn__hp_1.setText("曾是皇家骑士的侍从");


                TextView tv_1 = (TextView) findViewById(R.id.cj_tv_1);
                tv_1.setText("你童年曾经历过什么？");
                break;
            case 2:
                Button btn__min_2 = (Button) findViewById(R.id.cj_btn_3);
                btn__min_2.setText("带领精英在夜晚偷袭敌阵");
                Button btn__zhi_2 = (Button) findViewById(R.id.cj_btn_2);
                btn__zhi_2.setText("暂时退兵，利用筹码换取国王");
                Button btn__li_2 = (Button) findViewById(R.id.cj_btn_1);
                btn__li_2.setText("以势不可挡的力量冲入敌阵，救出国王");
                Button btn__hp_2 = (Button) findViewById(R.id.cj_btn_4);
                btn__hp_2.setText("带领骑兵从敌军后方撕裂敌阵，歼灭敌人");

                TextView tv_2 = (TextView) findViewById(R.id.cj_tv_1);
                tv_2.setText("如果国王正被围攻，你会。。");
                break;
            case 3:
                Button btn__hp_3 = (Button) findViewById(R.id.cj_btn_4);
                btn__hp_3.setText("为了拯救这个黑暗的世界");
                Button btn__min_3 = (Button) findViewById(R.id.cj_btn_3);
                btn__min_3.setText("为了寻找惊世的宝藏");
                Button btn__zhi_3 = (Button) findViewById(R.id.cj_btn_2);
                btn__zhi_3.setText("为了学习神奇的魔法");
                Button btn__li_3 = (Button) findViewById(R.id.cj_btn_1);
                btn__li_3.setText("当然是为了征服这里！");


                TextView tv_3 = (TextView) findViewById(R.id.cj_tv_1);
                tv_3.setText("你为何来到艾泽拉斯？");
                break;
            case 4:
                Button btn__hp_4 = (Button) findViewById(R.id.cj_btn_4);
                btn__hp_4.setText("建立一个不朽的帝国");
                Button btn__min_4 = (Button) findViewById(R.id.cj_btn_3);
                btn__min_4.setText("与心爱之人游山玩水，岂不快哉");
                Button btn__zhi_4 = (Button) findViewById(R.id.cj_btn_2);
                btn__zhi_4.setText("进一步探索古神的力量");
                Button btn__li_4 = (Button) findViewById(R.id.cj_btn_1);
                btn__li_4.setText("那岂不理我的梦想更近一步！杀！");

                li = li + 1;

                TextView tv_4 = (TextView) findViewById(R.id.cj_tv_1);
                tv_4.setText("如果你有盖世的力量，你会。。");
                break;
            case 5:
                Button btn__hp_5 = (Button) findViewById(R.id.cj_btn_4);
                btn__hp_5.setText("生命：" + mhp);
                Button btn__min_5 = (Button) findViewById(R.id.cj_btn_3);
                btn__min_5.setText("敏捷：" + mmin);
                Button btn__zhi_5 = (Button) findViewById(R.id.cj_btn_2);
                btn__zhi_5.setText("智力：" + mzhi);
                Button btn__li_5 = (Button) findViewById(R.id.cj_btn_1);
                btn__li_5.setText("力量： " + mli);
                zhiye();
                break;


        }

    }

    public void zhili(View view) {
        liliang = new Random().nextInt(20) + 80;
        mli = li * 50 + liliang;
        times = times + 1;


        zhili = new Random().nextInt(20) + 80;
        mzhi = zhi * 50 + zhili;
        zhi = zhi + 1;

        minjie = new Random().nextInt(20) + 80;
        mmin = min * 50 + minjie;


        shengming = new Random().nextInt(20) + 80;
        mhp = hp * 50 + shengming;


        switch (times) {

            case 2:
                Button btn__min_2 = (Button) findViewById(R.id.cj_btn_3);
                btn__min_2.setText("带领精英在夜晚偷袭敌阵");
                Button btn__zhi_2 = (Button) findViewById(R.id.cj_btn_2);
                btn__zhi_2.setText("暂时退兵，利用筹码换取国王");
                Button btn__li_2 = (Button) findViewById(R.id.cj_btn_1);
                btn__li_2.setText("以势不可挡的力量冲入敌阵，救出国王");
                Button btn__hp_2 = (Button) findViewById(R.id.cj_btn_4);
                btn__hp_2.setText("带领骑兵从敌军后方撕裂敌阵，歼灭敌人");

                TextView tv_2 = (TextView) findViewById(R.id.cj_tv_1);
                tv_2.setText("如果国王正被围攻，你会。。");
                break;
            case 3:
                Button btn__hp_3 = (Button) findViewById(R.id.cj_btn_4);
                btn__hp_3.setText("为了拯救这个黑暗的世界");
                Button btn__min_3 = (Button) findViewById(R.id.cj_btn_3);
                btn__min_3.setText("为了寻找惊世的宝藏");
                Button btn__zhi_3 = (Button) findViewById(R.id.cj_btn_2);
                btn__zhi_3.setText("为了学习神奇的魔法");
                Button btn__li_3 = (Button) findViewById(R.id.cj_btn_1);
                btn__li_3.setText("当然是为了征服这里！");


                TextView tv_3 = (TextView) findViewById(R.id.cj_tv_1);
                tv_3.setText("你为何来到艾泽拉斯？");
                break;
            case 4:
                Button btn__hp_4 = (Button) findViewById(R.id.cj_btn_4);
                btn__hp_4.setText("建立一个不朽的帝国");
                Button btn__min_4 = (Button) findViewById(R.id.cj_btn_3);
                btn__min_4.setText("与心爱之人游山玩水，岂不快哉");
                Button btn__zhi_4 = (Button) findViewById(R.id.cj_btn_2);
                btn__zhi_4.setText("进一步探索古神的力量");
                Button btn__li_4 = (Button) findViewById(R.id.cj_btn_1);
                btn__li_4.setText("那岂不理我的梦想更近一步！杀！");

                zhi = zhi + 1;

                TextView tv_4 = (TextView) findViewById(R.id.cj_tv_1);
                tv_4.setText("如果你有盖世的力量，你会。。");
                break;
            case 5:
                Button btn__hp_5 = (Button) findViewById(R.id.cj_btn_4);
                btn__hp_5.setText("生命：" + mhp);
                Button btn__min_5 = (Button) findViewById(R.id.cj_btn_3);
                btn__min_5.setText("敏捷：" + mmin);
                Button btn__zhi_5 = (Button) findViewById(R.id.cj_btn_2);
                btn__zhi_5.setText("智力：" + mzhi);
                Button btn__li_5 = (Button) findViewById(R.id.cj_btn_1);
                btn__li_5.setText("力量： " + mli);
                zhiye();
                break;

        }
    }

    public void minjie(View view) {
        liliang = new Random().nextInt(20) + 80;
        mli = li * 50 + liliang;
        times = times + 1;


        zhili = new Random().nextInt(20) + 80;
        mzhi = zhi * 50 + zhili;


        minjie = new Random().nextInt(20) + 80;
        mmin = min * 50 + minjie;
        min = min + 1;

        shengming = new Random().nextInt(20) + 80;
        mhp = hp * 50 + shengming;


        switch (times) {

            case 2:
                Button btn__min_2 = (Button) findViewById(R.id.cj_btn_3);
                btn__min_2.setText("带领精英在夜晚偷袭敌阵");
                Button btn__zhi_2 = (Button) findViewById(R.id.cj_btn_2);
                btn__zhi_2.setText("暂时退兵，利用筹码换取国王");
                Button btn__li_2 = (Button) findViewById(R.id.cj_btn_1);
                btn__li_2.setText("以势不可挡的力量冲入敌阵，救出国王");
                Button btn__hp_2 = (Button) findViewById(R.id.cj_btn_4);
                btn__hp_2.setText("带领骑兵从敌军后方撕裂敌阵，歼灭敌人");

                TextView tv_2 = (TextView) findViewById(R.id.cj_tv_1);
                tv_2.setText("如果国王正被围攻，你会。。");
                break;
            case 3:
                Button btn__hp_3 = (Button) findViewById(R.id.cj_btn_4);
                btn__hp_3.setText("为了拯救这个黑暗的世界");
                Button btn__min_3 = (Button) findViewById(R.id.cj_btn_3);
                btn__min_3.setText("为了寻找惊世的宝藏");
                Button btn__zhi_3 = (Button) findViewById(R.id.cj_btn_2);
                btn__zhi_3.setText("为了学习神奇的魔法");
                Button btn__li_3 = (Button) findViewById(R.id.cj_btn_1);
                btn__li_3.setText("当然是为了征服这里！");


                TextView tv_3 = (TextView) findViewById(R.id.cj_tv_1);
                tv_3.setText("你为何来到艾泽拉斯？");
                break;
            case 4:
                Button btn__hp_4 = (Button) findViewById(R.id.cj_btn_4);
                btn__hp_4.setText("建立一个不朽的帝国");
                Button btn__min_4 = (Button) findViewById(R.id.cj_btn_3);
                btn__min_4.setText("与心爱之人游山玩水，岂不快哉");
                Button btn__zhi_4 = (Button) findViewById(R.id.cj_btn_2);
                btn__zhi_4.setText("进一步探索古神的力量");
                Button btn__li_4 = (Button) findViewById(R.id.cj_btn_1);
                btn__li_4.setText("那岂不理我的梦想更近一步！杀！");

                min = min + 1;

                TextView tv_4 = (TextView) findViewById(R.id.cj_tv_1);
                tv_4.setText("如果你有盖世的力量，你会。。");
                break;
            case 5:
                Button btn__hp_5 = (Button) findViewById(R.id.cj_btn_4);
                btn__hp_5.setText("生命：" + mhp);
                Button btn__min_5 = (Button) findViewById(R.id.cj_btn_3);
                btn__min_5.setText("敏捷：" + mmin);
                Button btn__zhi_5 = (Button) findViewById(R.id.cj_btn_2);
                btn__zhi_5.setText("智力：" + mzhi);
                Button btn__li_5 = (Button) findViewById(R.id.cj_btn_1);
                btn__li_5.setText("力量： " + mli);
                zhiye();
                break;
        }
    }

    public void hp(View view) {
        liliang = new Random().nextInt(20) + 80;
        mli = li * 50 + liliang;
        times = times + 1;


        zhili = new Random().nextInt(20) + 80;
        mzhi = zhi * 50 + zhili;


        minjie = new Random().nextInt(20) + 80;
        mmin = min * 50 + minjie;


        shengming = new Random().nextInt(20) + 80;
        mhp = hp * 50 + shengming;
        hp = hp + 1;

        switch (times) {

            case 2:
                Button btn__min_2 = (Button) findViewById(R.id.cj_btn_3);
                btn__min_2.setText("带领精英在夜晚偷袭敌阵");
                Button btn__zhi_2 = (Button) findViewById(R.id.cj_btn_2);
                btn__zhi_2.setText("暂时退兵，利用筹码换取国王");
                Button btn__li_2 = (Button) findViewById(R.id.cj_btn_1);
                btn__li_2.setText("以势不可挡的力量冲入敌阵，救出国王");
                Button btn__hp_2 = (Button) findViewById(R.id.cj_btn_4);
                btn__hp_2.setText("带领骑兵从敌军后方撕裂敌阵，歼灭敌人");

                TextView tv_2 = (TextView) findViewById(R.id.cj_tv_1);
                tv_2.setText("如果国王正被围攻，你会。。");
                break;
            case 3:
                Button btn__hp_3 = (Button) findViewById(R.id.cj_btn_4);
                btn__hp_3.setText("为了拯救这个黑暗的世界");
                Button btn__min_3 = (Button) findViewById(R.id.cj_btn_3);
                btn__min_3.setText("为了寻找惊世的宝藏");
                Button btn__zhi_3 = (Button) findViewById(R.id.cj_btn_2);
                btn__zhi_3.setText("为了学习神奇的魔法");
                Button btn__li_3 = (Button) findViewById(R.id.cj_btn_1);
                btn__li_3.setText("当然是为了征服这里！");

                TextView tv_3 = (TextView) findViewById(R.id.cj_tv_1);
                tv_3.setText("你为何来到艾泽拉斯？");
                break;
            case 4:
                Button btn__hp_4 = (Button) findViewById(R.id.cj_btn_4);
                btn__hp_4.setText("建立一个不朽的帝国");
                Button btn__min_4 = (Button) findViewById(R.id.cj_btn_3);
                btn__min_4.setText("与心爱之人游山玩水，岂不快哉");
                Button btn__zhi_4 = (Button) findViewById(R.id.cj_btn_2);
                btn__zhi_4.setText("进一步探索古神的力量");
                Button btn__li_4 = (Button) findViewById(R.id.cj_btn_1);
                btn__li_4.setText("那岂不理我的梦想更近一步！杀！");
                hp = hp + 1;

                TextView tv_4 = (TextView) findViewById(R.id.cj_tv_1);
                tv_4.setText("如果你有盖世的力量，你会。。");
                break;
            case 5:
                Button btn__hp_5 = (Button) findViewById(R.id.cj_btn_4);
                btn__hp_5.setText("生命：" + mhp);
                Button btn__min_5 = (Button) findViewById(R.id.cj_btn_3);
                btn__min_5.setText("敏捷：" + mmin);
                Button btn__zhi_5 = (Button) findViewById(R.id.cj_btn_2);
                btn__zhi_5.setText("智力：" + mzhi);
                Button btn__li_5 = (Button) findViewById(R.id.cj_btn_1);
                btn__li_5.setText("力量： " + mli);
                zhiye();
                break;
        }
    }

    public void zhiye() {
        if (li >= 2 && hp >= 2) {
            TextView tv_4 = (TextView) findViewById(R.id.cj_tv_1);
            tv_4.setText("你将成为一个正义的战士");
        }
        if (hp >= 3) {
            TextView tv_4 = (TextView) findViewById(R.id.cj_tv_1);
            tv_4.setText("你将成为一个沙包");
        }
        if (li >= 3) {
            TextView tv_4 = (TextView) findViewById(R.id.cj_tv_1);
            tv_4.setText("你将成为一个暴君");
        }
        if (zhi >= 2 && li >= 2) {
            TextView tv_4 = (TextView) findViewById(R.id.cj_tv_1);
            tv_4.setText("你将成为一个战斗法师");
        }
        if (min >= 2 && zhi >= 2) {
            TextView tv_4 = (TextView) findViewById(R.id.cj_tv_1);
            tv_4.setText("你将成为一个精灵弓箭手");
        }
        if (li >= 2 && min >= 2) {
            TextView tv_4 = (TextView) findViewById(R.id.cj_tv_1);
            tv_4.setText("你将成为一个游侠");
        }
        if (zhi >= 3) {
            TextView tv_4 = (TextView) findViewById(R.id.cj_tv_1);
            tv_4.setText("你将成为一个黑暗魔法师");
        }
    }

    public void replay(View view) {
        times = 0;
        li = 0;
        mli = 0;

        zhi = 0;
        mzhi = 0;

        min = 0;
        mmin = 0;

        hp = 0;
        mhp = 0;

        TextView tv_4 = (TextView) findViewById(R.id.cj_tv_1);
        tv_4.setText("创建一个人物");

        Button btn__hp_5 = (Button) findViewById(R.id.cj_btn_4);
        btn__hp_5.setText(" ");
        Button btn__min_5 = (Button) findViewById(R.id.cj_btn_3);
        btn__min_5.setText(" ");
        Button btn__zhi_5 = (Button) findViewById(R.id.cj_btn_2);
        btn__zhi_5.setText(" ");
        Button btn__li_5 = (Button) findViewById(R.id.cj_btn_1);
        btn__li_5.setText("开始");

    }

}
