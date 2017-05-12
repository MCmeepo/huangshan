package com.meepo.huangshan.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.meepo.huangshan.R;

public class L5test3 extends AppCompatActivity {

    int d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l5test3);

        //        1.获取意图
        Intent intent = getIntent();
//        2.获取意图中的数据
        int a = intent.getIntExtra("power1", 0);
        int b = intent.getIntExtra("power2", 0);
        int c = intent.getIntExtra("power3", 0);
        int btn = intent.getIntExtra("btn", 0);

        if (a >= b && a >= c && btn == 1) {
            TextView L5_tv = (TextView) findViewById(R.id.L5test3_tv1);
            L5_tv.setText("关羽带领蜀国统一了中国！！ ");

            TextView L5_btn1 = (TextView) findViewById(R.id.L5test3_btn1);
            L5_btn1.setText("解甲归田 ");
            return;
        }

        if (b >= c && b >= a && btn == 2) {
            TextView L5_tv = (TextView) findViewById(R.id.L5test3_tv1);
            L5_tv.setText("刘备带领蜀国统一了中国！！ ");

            TextView L5_btn1 = (TextView) findViewById(R.id.L5test3_btn1);
            L5_btn1.setText("解甲归田 ");
            return;
        }

        if (c >= b && c >= a && btn == 3) {
            TextView L5_tv = (TextView) findViewById(R.id.L5test3_tv1);
            L5_tv.setText("张飞带领蜀国统一了中国！！ ");

            TextView L5_btn1 = (TextView) findViewById(R.id.L5test3_btn1);
            L5_btn1.setText("解甲归田 ");
            return;
        }


        TextView L5_tv = (TextView) findViewById(R.id.L5test3_tv1);
        L5_tv.setText("你已全军覆没！！ ");

        TextView L5_btn1 = (TextView) findViewById(R.id.L5test3_btn1);
        L5_btn1.setText("东山再起！ ");
    }



    public void tiaozhuan(View view) {
//        1.构建意图
        Intent tiaozhuan = new Intent();
//        2.给意图指定跳转页
        tiaozhuan.setClass(this, L5test1.class);

//        4.执行跳转
        startActivity(tiaozhuan);
    }

}

