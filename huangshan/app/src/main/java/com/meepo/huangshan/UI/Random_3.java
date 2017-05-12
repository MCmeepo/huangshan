package com.meepo.huangshan.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.meepo.huangshan.R;

import java.util.Arrays;
import java.util.Random;

public class Random_3 extends AppCompatActivity {
    int a;
    int b;
    int c;
    int along = 0;
    int dan = 0;
    int mc = 0;
    int ab;
    private int abc;
    private int ac;
    private int bc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_3);
    }

    public void random3num(View view) {

        for (int i = 0; i < 10000; i++) {
            make_rdnum();
//        compare();
            calculateCount();
        }
    }

    private void calculateCount() {
        int[] array = new int[3];
        array[0] = a;
        array[1] = b;
        array[2] = c;
        Arrays.sort(array);
        if (array[1] == a) {
            along++;
        }
        if (array[1] == b) {
            dan++;
        }
        if (array[1] == c) {
            mc++;
        }
        TextView rd3_tv4 = (TextView) findViewById(R.id.rd3_tv_4);
        rd3_tv4.setText("drink: " + along + " dan: " + dan + " mc: " + mc);
    }

    public void times() {
        if (a > b) {
            if (a > c) {
                along = along + 1;
            } else mc = mc + 1;
        } else
            if (b > c) {
                dan = dan + 1;
            } else mc = mc + 1;


        if (a == b && b == c) {
            abc++;
        }
        if (a == b) {
            ab++;
        }
        if (a == c) {
            ac++;
        }
        if (b == c) {
            bc++;
        }

        TextView rd3_tv4 = (TextView) findViewById(R.id.rd3_tv_4);
        rd3_tv4.setText("drink: " + along + " dan: " + dan + " mc: " + mc + "\na=b=c: " + abc + " a=b: " + ab + " a=c: "+ ac + " b=c: " + bc);

    }

    public void clear_rdnum(View view) {
        TextView rd3_tv1 = (TextView) findViewById(R.id.rd3_tv_1);
        rd3_tv1.setText("drink");

        TextView rd3_tv2 = (TextView) findViewById(R.id.rd3_tv_2);
        rd3_tv2.setText("dan");

        TextView rd3_tv3 = (TextView) findViewById(R.id.rd3_tv_3);
        rd3_tv3.setText("mc");

        TextView rd3_tv4 = (TextView) findViewById(R.id.rd3_tv_4);
        rd3_tv4.setText("drink:0 dan:0 mc:0 ");

        along = 0;
        dan = 0;
        mc = 0;

        Toast.makeText(this, "清零了哦", Toast.LENGTH_SHORT).show();

    }

    public void make_rdnum() {
        a = new Random().nextInt(100);
        b = new Random().nextInt(100);
        c = new Random().nextInt(100);

        TextView rd3_tv1 = (TextView) findViewById(R.id.rd3_tv_1);
        rd3_tv1.setText("drink: " + a);

        TextView rd3_tv2 = (TextView) findViewById(R.id.rd3_tv_2);
        rd3_tv2.setText("dan: " + b);

        TextView rd3_tv3 = (TextView) findViewById(R.id.rd3_tv_3);
        rd3_tv3.setText("mc: " + c);


    }

    public void compare() {
        if (a > b) {
            if (a > c) {
                Toast.makeText(this, "最大值为along：" + a, Toast.LENGTH_SHORT).show();
            } else
                Toast.makeText(this, "最大值为mc：" + c, Toast.LENGTH_SHORT).show();
        } else if (b > c) {
            Toast.makeText(this, "最大值为dan：" + b, Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(this, "最大值为mc：" + c, Toast.LENGTH_SHORT).show();
    }


}
