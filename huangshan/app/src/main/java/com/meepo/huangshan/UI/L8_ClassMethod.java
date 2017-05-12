package com.meepo.huangshan.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.meepo.huangshan.R;
import com.meepo.huangshan.bean.L8_Player;


public class L8_ClassMethod extends AppCompatActivity {

    public TextView L8_tv1;
    public Button L8_btn1;
    public Button L8_btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l8__class_method);

        initViews();
    }


    public void output(View view) {

//     1.定义人物属性
        L8_Player player1 = new L8_Player();
        player1.setName("阿龙");
        player1.setAge(6);

//     2.输出人物属性

        L8_tv1.setText("玩家名： " + player1.getName() + "\n年龄： " + player1.getAge());

    }

    public void output2(View view) {
        L8_Player player2 = new L8_Player();
        L8_tv1.setText("玩家名： " + player2.getName() + "\n年龄： " + player2.getAge());


    }

    public void initViews() {

        L8_tv1 = (TextView) findViewById(R.id.L8_tv_1);
        L8_btn1 = (Button) findViewById(R.id.L8test_btn1);
        L8_btn2 = (Button) findViewById(R.id.L8_btn_2);

    }
}
