package com.meepo.huangshan.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.meepo.huangshan.R;

public class L10Timer extends AppCompatActivity {
    private Button l10_btn;
    private int mtime = 5;
    private boolean state = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l10_timer);

        l10_btn = (Button) findViewById(R.id.L10_btn);
    }

    public void report(View view) {
        if(mtime ==0){
            mtime=6;
        }
        if (state) {
            ChangeButtonTimer textTimer = new ChangeButtonTimer();
            Thread thread = new Thread(textTimer);
            thread.start();
        }else{
            Toast.makeText(this, "你还不能点击！！", Toast.LENGTH_SHORT).show();
        }

    }

    private class ChangeButtonTimer implements Runnable {
        @Override
        public void run() {
            state = false;
            while (mtime > 0) {
                try {
                    Thread.sleep(1000);
                    mtime = mtime - 1;
                    runOnUiThread(new ChangeButtonRunnable());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            state = true;
        }
    }

    private class ChangeButtonRunnable implements Runnable {
        @Override
        public void run() {
            l10_btn.setText(mtime+"");
        }
    }
}



