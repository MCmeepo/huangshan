package com.meepo.huangshan.UI;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.meepo.huangshan.R;

public class L15_dialog extends AppCompatActivity {
    private Button Message;
    private Button Items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l15_dialog);

        initViews();
    }

    public void showSimpleDialog(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("王雨萱身高只有1.49米");
        builder.setNegativeButton("不相信",new L15DialogLinstener());
        builder.setPositiveButton("知道了",new L15DialogLinstener());
        builder.setNeutralButton("无所谓",null);
        builder.create().show();
    }

    public void showItemDialog(View view){
        String[] array ={"1.55米","1.5米","1.49米"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("王雨萱有多高？");
        builder.setItems(array,new L15ItemsLinstener());
        builder.create().show();
    }

    public class L15ItemsLinstener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if(which==3){
                Toast.makeText(L15_dialog.this,"bingo",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public class L15DialogLinstener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which){
                case -1:
                    Toast.makeText(L15_dialog.this,"嗯",Toast.LENGTH_SHORT).show();
                    break;
                case -2:
                    Toast.makeText(L15_dialog.this,"那你重点一次",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    public void initViews(){
        Message = (Button)findViewById(R.id.L15_btn_simple);
        Items = (Button)findViewById(R.id.L15_btn_itmes);
    }
}
