package com.meepo.huangshan.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

import com.meepo.huangshan.R;

public class L5test1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l5test1);
    }

    public void tiaozhuan(View view) {
//        1.构建意图
        Intent tiaozhuan = new Intent();
//        2.给意图指定跳转页
        tiaozhuan.setClass(this,L5test2.class);
//        3.将需要传输的数据放入意图

        EditText L5_et1 = (EditText) findViewById(R.id.L5test1_et1);
        Editable L5_et_name = L5_et1.getText();
        String name = L5_et_name.toString();

        tiaozhuan.putExtra("name", name);
//        4.执行跳转
        startActivity(tiaozhuan);
    }
}
