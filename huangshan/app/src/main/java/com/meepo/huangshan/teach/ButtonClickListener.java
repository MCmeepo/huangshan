package com.meepo.huangshan.teach;

import android.view.View;
import android.widget.Toast;

/**
 * Created by meepo on 2017/3/1.
 */
public class ButtonClickListener implements View.OnClickListener {

    private L16BtnEditLogActivity mAct;

    public ButtonClickListener(L16BtnEditLogActivity activity) {
        this.mAct = activity;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(mAct, "点击了一下", Toast.LENGTH_SHORT).show();
    }
}
