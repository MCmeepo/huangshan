package com.meepo.huangshan.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.meepo.huangshan.R;

import java.util.Random;

public class Random_Activity extends AppCompatActivity {
    int times = 0;
    int a;
    int b;
    int c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_);
    }

    public void randonnum(View view) {
        times = times + 1;
        switch (times) {
            case 1:
                a = new Random().nextInt(40);
                TextView tv_1 = (TextView) findViewById(R.id.ran_tv_1);
                tv_1.setText("drink: " + a);
                break;
            case 2:
                b = new Random().nextInt(40) + 61;
                TextView tv_2 = (TextView) findViewById(R.id.ran_tv_2);
                tv_2.setText("dan: " + b);
                break;
            case 3:
                c = new Random().nextInt(40) + 61;
                TextView tv_3 = (TextView) findViewById(R.id.ran_tv_3);
                tv_3.setText("mc: " + c);
                times = 0;
                break;
        }
    }

    public void clear(View view) {
        TextView tv_1 = (TextView) findViewById(R.id.ran_tv_1);
        tv_1.setText("谁最小谁吃屎");

        TextView tv_2 = (TextView) findViewById(R.id.ran_tv_2);
        tv_2.setText("谁最小谁吃屎");

        TextView tv_3 = (TextView) findViewById(R.id.ran_tv_3);
        tv_3.setText("谁最小谁吃屎");

        times = 0;
    }
}
