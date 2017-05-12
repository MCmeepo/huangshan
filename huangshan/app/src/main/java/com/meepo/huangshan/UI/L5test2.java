package com.meepo.huangshan.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.meepo.huangshan.R;

import java.util.Random;

public class L5test2 extends AppCompatActivity {

    int a = new Random().nextInt(100);
    int b = new Random().nextInt(100);
    int c = new Random().nextInt(100);
    int btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l5test2);

        //        1.获取意图
        Intent intent = getIntent();
//        2.获取意图中的数据
        String name = intent.getStringExtra("name");
        TextView L5_tv = (TextView) findViewById(R.id.L5test2_tv1);
        L5_tv.setText(name + "将军！欢迎来到蜀国，选择你最强的武将出征吧！！ ");


        Button L5test_btn1 = (Button) findViewById(R.id.L5test2_btn1);
        L5test_btn1.setText("关羽： " + a);

        Button L5test_btn2 = (Button) findViewById(R.id.L5test2_btn2);
        L5test_btn2.setText("刘备： " + b);

        Button L5test_btn3 = (Button) findViewById(R.id.L5test2_btn3);
        L5test_btn3.setText("张飞： " + c);

    }

    public void tiaozhuan1(View view) {
        btn = 1;
        TiaozhuanBtn(view);
    }

    public void tiaozhuan2(View view) {
        btn = 2;
        TiaozhuanBtn(view);
    }

    public void tiaozhuan3(View view) {
        btn = 3;
        TiaozhuanBtn(view);
    }

    public void TiaozhuanBtn(View view) {

        //        1.构建意图
        Intent tiaozhuan = new Intent();
//        2.给意图指定跳转页
        tiaozhuan.setClass(this, L5test3.class);
//        3.将需要传输的数据放入意图


        tiaozhuan.putExtra("power1", a);
        tiaozhuan.putExtra("power2", b);
        tiaozhuan.putExtra("power3", c);
        tiaozhuan.putExtra("btn", btn);

//        4.执行跳转
        startActivity(tiaozhuan);

    }

}
