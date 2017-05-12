package com.meepo.huangshan.bean;

import android.content.Context;
import android.widget.Toast;

public class HsToast {

    public static void sShow(Context context, String content) {
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
    }
}
