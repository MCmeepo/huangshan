package com.meepo.huangshan.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.meepo.huangshan.R;

public class L10test extends AppCompatActivity {

    private Button l10test_btn;
    private TextView l10test_tv;
    private int mnum = 10;
    private boolean mstate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l10test);

        l10test_btn = (Button) findViewById(R.id.L10test_btn);
        l10test_tv = (TextView) findViewById(R.id.L10test_tv);


    }

    public void freeze(View view) {
        Switching(mstate);
        Switch(mstate);
    }

    public void Switching(boolean state){
        if(state){
            mstate = false;
        }else {
            mstate = true;
        }
    }

    private class DigitalChange implements Runnable {
        @Override
        public void run() {
            while (mstate ) {
                try {
                    mnum = mnum - 1;
                    runOnUiThread(new ChangeButtonRunnable());
                    Thread.sleep(100);
                    if (mnum == 0) {
                        mnum = 10;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class ChangeButtonRunnable implements Runnable {
        @Override
        public void run() {
            l10test_btn.setText(mnum + "");
        }
    }


    public void Switch(boolean state) {
        if (state) {

            DigitalChange Roll = new DigitalChange();
            Thread thread = new Thread(Roll);
            thread.start();

            l10test_tv.setText("GO!");
        } else {
            Stop(mnum);
        }
    }

    public void Stop(int num) {
        if (num == 5) {
            l10test_tv.setText("You win!");
        } else {
            l10test_tv.setText("You lost!");
        }
    }

}
