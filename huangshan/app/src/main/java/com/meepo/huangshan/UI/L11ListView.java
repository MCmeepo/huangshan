package com.meepo.huangshan.UI;

import android.hardware.camera2.TotalCaptureResult;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.meepo.huangshan.R;

public class L11ListView extends AppCompatActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l11_list_view);

//        1.加载 ListView
        mListView = (ListView) findViewById(R.id.L11_LV);

//        2.准备要展示的数据
        String[] num = new String[100];
        for (int i = 0; i < num.length; i = i + 1) {
            num[i] = i + "";
        }

//        3.将数据绑定到 Adapter（适配器） 上
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, num);
//        4.为 ListView 设置 Adapter
        mListView.setAdapter(arrayAdapter);

//        5.为 ListView 添加点击事件,创建一个类，用于建立点击事件
        mListView.setOnItemClickListener(new OnItemClickListener());

    }

    class OnItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        //           侦测点击了第几行
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            String num = (String) adapterView.getItemAtPosition(position);

//          执行时间
            String content = num + position;
            Toast.makeText(L11ListView.this, content, Toast.LENGTH_SHORT).show();
        }
    }


}
