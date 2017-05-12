package com.meepo.huangshan.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.meepo.huangshan.R;
import com.meepo.huangshan.bean.L13test_Red;
import com.meepo.huangshan.bean.L13test_User;

import java.util.Random;

public class L13test_B extends AppCompatActivity {
    private TextView l13b_tv;
    private ListView mListView;

    private L13test_Red Red = new L13test_Red();
    private L13test_User[] User;
    private String[] mdata;
    private String mName;

    private int usernum;            //用户数
    private int a;                 //随机名字
    private int ranMoney;       //金额随机范围

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l13test__b);

        initViews();
        indata();
        MakePlayer90();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mdata);
        mListView.setAdapter(arrayAdapter);

        l13b_tv.setText(User[0].Name + " " + User[0].Money);
    }

    public void MakePlayer90() {
        User = new L13test_User[usernum];
        mdata = new String[usernum];
        for (int i = 0; i < usernum; i = i + 1) {
            a = new Random().nextInt(14);
            User[i] = new L13test_User();
            User[i].Name = MakeName(a);
            probability(i);
//         y剩余用户，x红包剩余金额与剩余用户之差
            int y = usernum - i;
            int x = Red.RedMoney - y;
            if (x > 0) {
                if (y > 1) {
                    int ranMoney = new Random().nextInt(x);
                    User[i].Money = ranMoney + 1;
                } else {
                    User[i].Money = Red.RedMoney;
                }
            } else {
                User[i].Money = 1;
            }
            mdata[i] = User[i].Name + "\n" + User[i].Money;
            Red.RedMoney = Red.RedMoney - User[i].Money;
        }
    }

    public void probability(int i) {
        int probability = new Random().nextInt(10000);
        if (probability > 8999 - i * 5) {
            ranMoney = Red.RedMoney * 100 / 80;
        }
        if (8999 - i * 5 > probability && probability > 6999) {
            ranMoney = Red.RedMoney * 100 / 60;
        }
        if (6999 > probability && probability > 3999 - i * 30) {

        }
        if (3999 - i * 30 > probability && probability > 1999 - i * 50) {

        }
        if (probability < 1999 - i * 50) {

        }
    }

    public void initViews() {
        l13b_tv = (TextView) findViewById(R.id.L13B_tv);
        mListView = (ListView) findViewById(R.id.L13B_Lv);
    }

    public void indata() {
        Intent next = getIntent();
        Red.RedMoney = next.getIntExtra("红包金额", 0);
        usernum = next.getIntExtra("红包数量", 0);
    }

    public String MakeName(int random) {
        switch (random) {
            case 1:
                mName = "阿龙";
                break;
            case 2:
                mName = "阿蛋";
                break;
            case 3:
                mName = "1";
                break;
            case 4:
                mName = "2";
                break;
            case 5:
                mName = "314";
                break;
            case 6:
                mName = "55";
                break;
            case 7:
                mName = " 地方";
                break;
            case 8:
                mName = "124";
                break;
            case 9:
                mName = "规范化";
                break;
            case 10:
                mName = "留";
                break;
            case 11:
                mName = "按时";
                break;
            case 12:
                mName = "124";
                break;
            case 13:
                mName = "大沙发";
                break;
            case 14:
                mName = "回家";
                break;
            case 15:
                mName = "阿斯顿";
                break;
            case 16:
                mName = "在";
                break;
            case 17:
                mName = "人员技能核桃仁 ";
                break;
            case 18:
                mName = "阿尔";
                break;
            case 19:
                mName = "截图看见";
                break;
            case 20:
                mName = "阿斯顿13";
                break;
            case 21:
                mName = "他已经";
                break;
            case 22:
                mName = "VC吧";
                break;
            case 23:
                mName = "i";
                break;
            case 24:
                mName = "阿福";
                break;
            case 25:
                mName = "一枯竭和个人的风格";
                break;
            case 26:
                mName = "史蒂夫";
                break;
            case 27:
                mName = "阿福阿斯顿人";
                break;
            case 28:
                mName = "都挺好叶世荣";
                break;
            case 29:
                mName = "人员集合";
                break;
            case 30:
                mName = "有空调监护人";
                break;
        }
        return mName;
    }

}
