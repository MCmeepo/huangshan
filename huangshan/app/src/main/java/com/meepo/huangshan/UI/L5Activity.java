package com.meepo.huangshan.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

import com.meepo.huangshan.R;

public class L5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l5);
    }

    public void tiaozhuan(View view) {
//        1.构建意图
        Intent tiaozhuan = new Intent();
//        2.给意图指定跳转页
        tiaozhuan.setClass(this, L5bActivity.class);
//        3.将需要传输的数据放入意图

        EditText L5_et1 = (EditText) findViewById(R.id.L5_et_name);
        Editable L5_et_name = L5_et1.getText();
        String name = L5_et_name.toString();

        EditText L5_et2 = (EditText) findViewById(R.id.L5_et_number);
        Editable L5_et_num = L5_et2.getText();
        String num = L5_et_num.toString();
        int number = Integer.parseInt(num);

        tiaozhuan.putExtra("name", name);
        tiaozhuan.putExtra("number", number);
//        4.执行跳转
        startActivity(tiaozhuan);
    }

}
