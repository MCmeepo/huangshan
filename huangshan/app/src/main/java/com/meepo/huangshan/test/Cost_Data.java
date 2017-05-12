package com.meepo.huangshan.test;

import android.widget.ImageView;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by meepo on 2017/4/22.
 */

public class Cost_Data {

    int mMoney;
    String mEvent;
    long mTime;

    Cost_Data(int money, String event, long time) {
        mMoney = money;
        mEvent = event;
        mTime = time;
    }

    public void setmMoney(int money) {
        mMoney = money;
    }

    public int getmMoney() {
        return mMoney;
    }

    public void setmEvent(String event) {
        mEvent = event;
    }

    public String getEvent() {
        return mEvent;
    }


//    System.currentTimeMillis();   获取当前时间

    public void setmTime(long time) {
        mTime = time;
    }

    public long getmTime() {
        return mTime;
    }

//    public void setmIV(ImageView iv) {
//        mIV = iv;
//    }
//
//    public ImageView getmIV() {
//        return mIV;
//    }

}



