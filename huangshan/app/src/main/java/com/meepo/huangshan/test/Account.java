package com.meepo.huangshan.test;

import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.meepo.huangshan.R;
import com.meepo.huangshan.UI.L15_dialog;
import com.meepo.huangshan.UI.L22_PopWindow;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Account extends AppCompatActivity {


    private ListView mlv;
    private TextView mtv;


    private List<Cost_Data> mCostDatas = new ArrayList<>();
    private LayoutInflater mInflater;
    private Adapter_Account mAdapter;
    private Cost_Data mcostdatas;

    private int mMoney;
    private String mEvent;
    private String mTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        initViews();
    }

    public void makeMoney(View v) {
        AlertDialog.Builder consumption = new AlertDialog.Builder(this);

         mInflater = LayoutInflater.from(this);
        LinearLayout root = new LinearLayout(this);
        View contentView = mInflater.inflate(R.layout.dialog, root);
        Button dlbtn = (Button) contentView.findViewById(R.id.ac_dl_btn);
        final EditText dlevent = (EditText) contentView.findViewById(R.id.ac_dl_event);
        final EditText dlmon =(EditText)  contentView.findViewById(R.id.ac_dl_money);

        consumption.setView(contentView);

        final AlertDialog dl = consumption.create();
        dl.show();

        dlbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEvent = dlevent.getText().toString();
                mMoney = mMoney + Integer.parseInt(dlmon.getText().toString());
//        Cost_Data data = new Cost_Data(Integer.parseInt(mETmon.getText().toString()),mEvent,);
                mtv.setText("$" + " " + mMoney);
                dl.dismiss();
                Cost_Data mcostdatas = new Cost_Data(Integer.parseInt(dlmon.getText().toString()),
                        mEvent,System.currentTimeMillis());
                mCostDatas.add(mcostdatas);
                mAdapter.notifyDataSetChanged();
            }
        });

    }



    private void initViews() {
        mtv = (TextView) findViewById(R.id.ac_money);
        mlv = (ListView) findViewById(R.id.ac_lv);

        mInflater = LayoutInflater.from(this);
        mAdapter = new Adapter_Account(this, mCostDatas);
        mlv.setAdapter(mAdapter);
    }
}

