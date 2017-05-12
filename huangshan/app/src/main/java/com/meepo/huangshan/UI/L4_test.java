package com.meepo.huangshan.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.meepo.huangshan.R;

import java.util.Random;

public class L4_test extends AppCompatActivity {
    int a;
    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l4_test);
    }

/*    作业  创建一个输入框，一个文本框，一个按钮
     输入框输入一个数字
    点击按钮在文本框输出一个小于输入数字的数*/

    public void randomnum(View view) {

        makenumber(view);     //      抓取文本框number    创建一个随机数a

        TextView L4_tv1 = (TextView) findViewById(R.id.L4test_tv1);
        L4_tv1.setText("你roll出了： " + a + "点，范围是( 0 ~ " + number + " )");
    }

    public void makenumber(View view) {


        EditText L4test_et = (EditText) findViewById(R.id.L4test_et_num1);                  //        1.获取输入框
        Editable L4_et_num = L4test_et.getText();                   //        2.获取输入框文本
        String num = L4_et_num.toString();
        number = Integer.parseInt(num);                        //        3.处理文本-将字符串转换为整型
        a = new Random().nextInt(number);

    }
}
