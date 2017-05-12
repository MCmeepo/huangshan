package com.meepo.huangshan.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.meepo.huangshan.R;

public class L4_EditText extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l4__edit_text);
    }

    public void go(View view) {
//        1.获取输入框
        EditText L4_et = (EditText) findViewById(R.id.L4_et_name);
//        2.获取输入框文本
        Editable L4_et_name = L4_et.getText();
        String name = L4_et_name.toString();
//        3.处理文本
        name = "你心目中的傻逼就是。。。" + name + "!!!!";
//        4.输出文本
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
    }

    public void numaddself(View view) {
        //        1.获取输入框
        EditText L4_et = (EditText) findViewById(R.id.L4_et_number);
//        2.获取输入框文本
        Editable L4_et_num = L4_et.getText();
        String num = L4_et_num.toString();
//        3.处理文本-将字符串转换为整型
        int namber = Integer.parseInt(num);
        int result = namber * 2;
//        4.输出文本
        Toast.makeText(this, "它的二倍是：　" + result, Toast.LENGTH_SHORT).show();
    }
}
