package com.meepo.huangshan.test;

/**
 * Created by meepo on 2017/4/22.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.meepo.huangshan.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Adapter_Account extends BaseAdapter {

    private final Context mContext;
    private final List<Cost_Data> mData;
    private SimpleDateFormat mFormatter = new SimpleDateFormat("yyyy年MM月dd日 E HH:mm:s", Locale.getDefault());

    Adapter_Account(Context context, List<Cost_Data> mdata) {
        mContext = context;
        mData = mdata;
    }



    @Override
    public int getCount() {
        return mData.size(); //size   arraylist的对象个数
    }

    @Override
    public Cost_Data getItem(int position) {    //获取arraylist中的数据对象
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {   //获取arraylist中的数据对象的id
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {    //获取某一项的子视图
        LayoutInflater inflater = LayoutInflater.from(mContext); //在布局填充器中，填入mContext
        com.meepo.huangshan.test.Adapter_Account.Holder holder; //建立一个holder，声明控件

        if (view == null) {
            // 该类型的布局第一次出现在界面上
            view = inflater.inflate(R.layout.adapter_account, viewGroup, false);
            holder = new com.meepo.huangshan.test.Adapter_Account.Holder();
            holder.mTVName = (TextView) view.findViewById(R.id.ac_ad_name);
            holder.mTvMoney = (TextView) view.findViewById(R.id.ac_ad_money);
            holder.mTvTime = (TextView) view.findViewById(R.id.ac_ad_time);
            // 把填好控件的 holder 放入控件的 tag 中
            view.setTag(holder);
        } else {
            // 从控件的 tag 中加载 holder
            holder = (com.meepo.huangshan.test.Adapter_Account.Holder) view.getTag();
        }

        // 通过索引从数据集合中获取数据对象
        Cost_Data costdata = mData.get(position);
        holder.mTvMoney.setText(""+costdata.getmMoney());
        holder.mTVName.setText(costdata.getEvent());
        holder.mTvTime.setText(mFormatter.format(new Date(costdata.getmTime())));
        return view;
    }

    private class Holder {
        ImageView mIm;
        TextView mTVName;
        TextView mTvTime;
        TextView mTvMoney;
    }
}
