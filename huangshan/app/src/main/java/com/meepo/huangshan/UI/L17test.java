package com.meepo.huangshan.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.meepo.huangshan.R;


//点击按钮   输出结果：大、小写字母数量，数字数量、其他符号数量

public class L17test extends AppCompatActivity {
    private int mNumbers;
    private int mCapitals;
    private int mLowercaseletters;
    private int mOthers;

    private String InData;
    private String mPutData;
    private EditText l17_ed;
    private TextView l17_tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l17test);

        initViews();

    }


    public void OutData(View view) {
        InData = l17_ed.getText().toString();
        char[] PutData = InData.toCharArray();
        for (int i = 0; i < PutData.length; i++) {
            if (PutData[i] >= 'a' && PutData[i] <= 'z') {
                mLowercaseletters = mLowercaseletters + 1;
            } else {
                if (PutData[i] >= 'A' && PutData[i] <= 'Z') {
                    mCapitals = mCapitals + 1;
                } else {
                    if (PutData[i] >= '0' && PutData[i] <= '9') {
                        mNumbers = mNumbers + 1;
                    } else {
                        mOthers = mOthers + 1;
                    }
                }
            }
        }
        mPutData = "大写字母数： " + mCapitals + "\n小写字母数： " + mLowercaseletters + "\n数字数： " + mNumbers + "" +
                "\n其他字符数： " + mOthers;
        l17_tv.setText(mPutData);
        mPutData = "";
        mCapitals = 0;
        mLowercaseletters = 0;
        mNumbers = 0;
        mOthers = 0;
    }


    public void initViews() {
        l17_ed = (EditText) findViewById(R.id.L17_ed);
        l17_tv = (TextView) findViewById(R.id.L17_tv);
    }


}
