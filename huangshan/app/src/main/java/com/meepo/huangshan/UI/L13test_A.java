package com.meepo.huangshan.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.meepo.huangshan.R;
import com.meepo.huangshan.bean.L13test_Red;
import com.meepo.huangshan.bean.L13test_User;

import java.util.Random;

public class L13test_A extends AppCompatActivity {
    public L13test_Red Red = new L13test_Red();

    public EditText l13a_et_mon;
    public EditText l13a_et_num;
    public TextView l13a_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l13test_);

        initViews();
    }

    public void MakeRed(View view) {


//        2.获取输入框文本
        Editable l13a_mon = l13a_et_mon.getText();
        String money = l13a_mon.toString();
//        3.处理文本-将字符串转换为整型
        Red.RedMoney = Integer.parseInt(money);

        Editable l13a_num = l13a_et_num.getText();
        String number = l13a_num.toString();
        Red.RedNumber = Integer.parseInt(number);

        if (Red.RedMoney == 0 || Red.RedNumber == 0) {
            Toast.makeText(this, "请重新输入", Toast.LENGTH_SHORT).show();
            return;
        }
        if (Red.RedMoney >= Red.RedNumber) {
            Intent next = new Intent();
            next.putExtra("红包金额", Red.RedMoney);
            next.putExtra("红包数量", Red.RedNumber);
            next.setClass(this, L13test_B.class);
            startActivity(next);
        } else {
            Toast.makeText(this, "请重新输入", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    public void initViews() {
        l13a_tv = (TextView) findViewById(R.id.L13A_tv1);
        l13a_et_mon = (EditText) findViewById(R.id.L13A_et_money);
        l13a_et_num = (EditText) findViewById(R.id.L13A_et_num);
    }

}
