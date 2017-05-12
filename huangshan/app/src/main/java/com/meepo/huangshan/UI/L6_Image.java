package com.meepo.huangshan.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.meepo.huangshan.R;

import java.util.Random;

public class L6_Image extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l6__image);
    }

    public void changeIV(View view){
//        建立一个数组
        int[] array = new int[4];
        array[0]=R.mipmap.l6_1;
        array[1]=R.mipmap.l6_2;
        array[2]=R.mipmap.l6_3;
        array[3]=R.mipmap.l6_4;
//        随机出一个数组中的元素
        int a = new Random().nextInt(4);

        ImageView L6_iv = (ImageView)findViewById(R.id.L6_iv_1);
//        在mipmap寻找资源
        L6_iv.setImageResource(array[a]);

    }
}
