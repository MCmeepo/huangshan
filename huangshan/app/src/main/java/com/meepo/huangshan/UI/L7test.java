package com.meepo.huangshan.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.meepo.huangshan.R;
import com.meepo.huangshan.bean.L7_equip;
import com.meepo.huangshan.bean.drink;

public class L7test extends AppCompatActivity {
    //按钮编号
    int x;
    //    购买后剩余金额
    int a = 1000;


    TextView L7_tv1;
    TextView L7_tv2;

    ImageView L7_iv1;
    ImageView L7_iv2;

    Button L7_btn1;
    Button L7_btn2;

    L7_equip[] grils = new L7_equip[2];

    int times1;
    int times2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l7test);


        loading();


    }

    public void buy1(View view) {
        x = 0;
        buy();

    }

    public void buy2(View view) {
        x = 1;
        buy();
    }

    public void buy() {
        int b;
        b = a - grils[x].price;
        if (b >= 0) {

            a = a  - grils[x].price;
            L7_tv1.setText("剩余金额： " + a);
            L7_tv2.setText("你购买了：" + grils[x].name +
                    "\n花费: " + grils[x].price + " 个金币");
        } else {
            b = grils[x].price - a;

            L7_tv1.setText("剩余金额： " + a);
            L7_tv2.setText("你还无法购买" + grils[x].name +
                    "\n你还需要: " + b + " 个金币");
        }
    }

    public void buy1() {


        a = a - grils[x].price;
        if (a >= 0) {
            L7_tv1.setText("剩余金额： " + a);
            L7_tv2.setText("你购买了：" + grils[x].name +
                    "\n花费: " + grils[x].price + " 个金币");
        } else {
            a = a + grils[x].price;
            int b = grils[x].price - a;

            L7_tv1.setText("剩余金额： " + a);
            L7_tv2.setText("你还无法购买" + grils[x].name +
                    "\n你还需要: " + b + " 个金币");
        }


    }

    public void loading() {

        L7_tv1 = (TextView) findViewById(R.id.L7_tv_1);
        L7_tv2 = (TextView) findViewById(R.id.L7_tv_2);

        L7_iv1 = (ImageView) findViewById(R.id.L7_iv_1);
        L7_iv2 = (ImageView) findViewById(R.id.L7_iv_2);

        L7_iv1.setImageResource(R.mipmap.l6_1);
        L7_iv2.setImageResource(R.mipmap.l6_2);

        L7_btn1 = (Button) findViewById(R.id.L7_btn_1);
        L7_btn2 = (Button) findViewById(R.id.L7_btn_2);

        L7_btn1.setText("500");
        L7_btn2.setText("1500");

        L7_equip attribute1 = new L7_equip();
        L7_equip attribute2 = new L7_equip();

        attribute1.name = "京都花魁刘亦菲";
        attribute1.price = 500;
        grils[0] = attribute1;

        attribute2.name = "后宫母狗小燕子";
        attribute2.price = 1500;
        grils[1] = attribute2;


    }
}
