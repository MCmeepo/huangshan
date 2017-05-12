package com.meepo.huangshan.UI;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;


import com.meepo.huangshan.R;

import java.util.Random;

public class L22_PopWindow extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l22_popup_window);
    }

    public void gril1(View view) {
        LayoutInflater inflater = LayoutInflater.from(this);
        LinearLayout root = new LinearLayout(this);
        View contentView = inflater.inflate(R.layout.popup_window, root);
        TextView tvTitle = (TextView) contentView.findViewById(R.id.l22_pop_tv);
        ImageView iv = (ImageView) contentView.findViewById(R.id.l22_pop_iv);
        tvTitle.setText("一位鲜嫩的美女");
        iv.setImageResource(R.mipmap.l6_1);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(L22_PopWindow.this, "安肖媳妇", Toast.LENGTH_SHORT).show();
            }
        });

        int warp = LinearLayout.LayoutParams.WRAP_CONTENT;
        PopupWindow popupWindow = new PopupWindow(contentView, warp, warp);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
//        popupWindow.showAsDropDown(view, 100, 100);
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
    }


    public void gril2(View view) {
        LayoutInflater inflater = LayoutInflater.from(this);
        LinearLayout root = new LinearLayout(this);
        View contentView = inflater.inflate(R.layout.popup_window, root);
        TextView tvTitle = (TextView) contentView.findViewById(R.id.l22_pop_tv);
        ImageView iv = (ImageView) contentView.findViewById(R.id.l22_pop_iv);
        tvTitle.setText("一位健硕的美女");
        iv.setImageResource(R.mipmap.l6_2);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(L22_PopWindow.this, "mc媳妇", Toast.LENGTH_SHORT).show();
            }
        });

        int warp = LinearLayout.LayoutParams.WRAP_CONTENT;
        PopupWindow popupWindow = new PopupWindow(contentView, warp, warp);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
//        popupWindow.showAsDropDown(view, 100, 100);
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
    }


    public void aloog(View view) {
        LayoutInflater inflater = LayoutInflater.from(this);
        LinearLayout root = new LinearLayout(this);
        View contentView = inflater.inflate(R.layout.popup_window, root);
        TextView tvTitle = (TextView) contentView.findViewById(R.id.l22_pop_tv);
        ImageView iv = (ImageView) contentView.findViewById(R.id.l22_pop_iv);
        tvTitle.setText("阿龙");
        iv.setImageResource(R.mipmap.along);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(L22_PopWindow.this, "阿龙", Toast.LENGTH_SHORT).show();
            }
        });

        int warp = LinearLayout.LayoutParams.WRAP_CONTENT;
        PopupWindow popupWindow = new PopupWindow(contentView, warp, warp);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
//        popupWindow.showAsDropDown(view, 100, 100);
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
    }


}
