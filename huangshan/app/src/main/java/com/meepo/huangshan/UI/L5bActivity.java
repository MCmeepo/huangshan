package com.meepo.huangshan.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.meepo.huangshan.R;

public class L5bActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l5b);


//        1.获取意图
        Intent intent = getIntent();
//        2.获取意图中的数据
        int number = intent.getIntExtra("number", 0);
        String name = intent.getStringExtra("name");
//        3.对数据进行操作
        TextView L5_tv = (TextView) findViewById(R.id.L5b_tv1);
        L5_tv.setText("角色名 ： " + name + "\n年龄 ： " + number);
    }
}
