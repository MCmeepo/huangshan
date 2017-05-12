package com.meepo.huangshan.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.meepo.huangshan.R;

import java.util.Random;

public class L11test extends AppCompatActivity {


    private ListView mListView;
    private String[] mitem = new String[8];
    private String[] mname = new String[8];
    private int[] mdps = new int[8];
    private int min;
    private int x;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l11test);

        initViews();
        LongdingAdapter();

    }

    //    准备数据,绑定适配器,
    public void LongdingAdapter() {
//        准备数据
        londing();
        compare();
//        设置适配器
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mitem);
//        绑定适配器
        mListView.setAdapter(arrayAdapter);
//        添加点击事件
        mListView.setOnItemClickListener(new OnItemClickListener());
    }

    //    比出最小值
    public void compare() {
        min = mdps[0];
        for (int i = 1; i < mdps.length; i = i + 1) {
            x = mdps[i];
            if (x <= min) {
                min = x;
            }
        }
    }

    public void londing() {
        mname[0] = "凯尔萨斯";
        mname[1] = "阿尔萨斯";
        mname[2] = "杜隆坦";
        mname[3] = "萨尔";
        mname[4] = "提里奥佛丁";
        mname[5] = "哈利波特";
        mname[6] = "艾玛沃森";
        mname[7] = "阿龙";
//        random dps
        for (int i = 0; i < mitem.length; i = i + 1) {
            int dps = new Random().nextInt(10);
            mdps[i] = dps;
        }
//        准备每一项数据
        for (int i = 0; i < mitem.length; i = i + 1) {
            mitem[i] = mname[i] + "" + mdps[i];
        }
    }

    class OnItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        //           侦测点击了第几行
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//          比大小，出结果
            if (min == mdps[position]){
                Toast.makeText(L11test.this, "bingo", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(L11test.this, "deal", Toast.LENGTH_SHORT).show();
            }

        }
    }


    //加载控件
    public void initViews() {
        mListView = (ListView) findViewById(R.id.L11test_LV);
    }

}
