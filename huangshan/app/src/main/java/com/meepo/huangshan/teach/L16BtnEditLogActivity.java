package com.meepo.huangshan.teach;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.meepo.huangshan.R;

public class L16BtnEditLogActivity extends AppCompatActivity {

    private Button mBtn;
    private EditText mEtName;
    private TextView mTvLog;
    private String mLog;
    private int namber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l16_btn_edit_log);
        // 1. Button onClick
        // 2. EditText listener
        // 3. Log
        initView();
        Log.i("Info", "aloong eieiei~~~");
        Log.d("Debug", "mcmcmc eieieie~~~");
        Log.w("Warning", "adiwang eieieie~~~");
        Log.e("Error", "a;gks;hne'n");
    }

    private void initView() {
        mBtn = (Button) findViewById(R.id.l16_btn);
        mEtName = (EditText) findViewById(R.id.l16_et);
        mTvLog = (TextView) findViewById(R.id.l16_tv_log);

        mBtn.setOnClickListener(new ButtonClickListener(this));
        mEtName.addTextChangedListener(new EditWatchDog());
    }

    private class EditWatchDog implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//            writeText("before: s: " + s + ", start: " + start + ", count: " + count + ", after: " + after);
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
//            writeText("onText: s: " + s + ", start: " + start + ", before: " + before + ", count: " + count);
        }

        @Override
        public void afterTextChanged(Editable s) {
            String str  = s.toString();
            if (str.length() == 0) {
                writeText("0");
            }else {
                namber = Integer.parseInt(str);
                if (namber > 200) {
                    namber = 200;
                }
                writeText(namber + " ");
            }
        }
    }

    private void writeText(String content) {
        mTvLog.setText(content);
    }
}
