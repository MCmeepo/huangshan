package com.meepo.huangshan.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.meepo.huangshan.R;

public class L9Timer extends AppCompatActivity {

    private TextView L9_tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l9_timer);

        L9_tv1 =  (TextView) findViewById(R.id.L9_tv);
    }

    public void starrTimer(View view){
//        创建执行线程的类
        ChangeTextTimer textTimer = new ChangeTextTimer();
//        创建线程
       Thread thread = new Thread(textTimer) ;
//        执行线程
        thread.start();
    }

    private class ChangeTextTimer implements Runnable{
        @Override
//        固定格式  run
        public void run() {
            try {
//        睡五秒
                Thread.sleep(5000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
//        在主线程上执行操作 runOnUiThread方法
            runOnUiThread(new ChangeTextRunnable());
        }
    }

    private class ChangeTextRunnable implements Runnable{
        @Override
        public void run() {
            L9_tv1.setText("无敌！");
        }
    }

    }
