package com.meepo.huangshan.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.meepo.huangshan.R;

public class L9test extends AppCompatActivity {

    private int times;
    private boolean clickable;
    private TextView l9test_tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l9test);

        l9test_tv = (TextView) findViewById(R.id.L9test_tv);

        clickable = true;
    }

    public void add(View view) {


        if (times == 0) {
            //        创建执行线程的类
            ChangeTextTimer textTimer = new ChangeTextTimer();
            //        创建线程
            Thread thread = new Thread(textTimer);
            thread.start();
        }
        if(clickable){
            times = times +1;
        }else {

        }

        l9test_tv.setText("你操了贾静雯 " + times + " 次！");
    }

    public void clear(View view) {
        times = 0;
        clickable = true;
        l9test_tv.setText("开干？");
    }

    private class ChangeTextTimer implements Runnable {
        @Override
//        固定格式  run
        public void run() {
            try {
//        睡五秒
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clickable = false;
        }
    }
}

