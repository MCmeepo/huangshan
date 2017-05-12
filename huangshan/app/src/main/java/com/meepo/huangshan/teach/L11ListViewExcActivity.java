package com.meepo.huangshan.teach;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.meepo.huangshan.R;

import java.util.Objects;
import java.util.Random;

public class L11ListViewExcActivity extends AppCompatActivity {

    private ListView mLisView;
    private Random mRandom;
    private String[] mNameArray;
    private int[] mNumArray;
    private int mMin;
    private L11ListViewExcActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l11_list_view_exc);
        intiData();
        initView();
    }

    private void intiData() {
        activity = this;
        mRandom = new Random();
        mNameArray = new String[] {"along", "MC", "ADAN"};
        mNumArray = new int[mNameArray.length];
        mMin = Integer.MAX_VALUE;
        for (int i = 0; i < mNameArray.length; i++) {
            mNumArray[i] = mRandom.nextInt(100);
            mNameArray[i] = mNameArray[i] + " " + mNumArray[i];
            if (mNumArray[i] < mMin) {
                mMin = mNumArray[i];
            }
        }
    }

    private void initView() {
        mLisView = (ListView) findViewById(R.id.l11_exc_lv);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mNameArray);
        mLisView.setAdapter(adapter);
        mLisView.setOnItemClickListener(new OnHeroClickListener());
    }

    private class OnHeroClickListener implements android.widget.AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //   parent: 点击事件对应的 view
            //     view: 点击时对应的单项 view
            // position: 点击时对应单项 view 的位置
            //       id: 点击时对应单项数据的 id
            // 1. 拿到点击时的数字
            // 2. 和数组中最小值比较
            // 3. 弹出提示
            if (mNumArray[position] == mMin) {
                toast("bingo");
            } else {
                toast("fuck");
            }
        }
    }

    private void toast(String content) {
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
    }
}
