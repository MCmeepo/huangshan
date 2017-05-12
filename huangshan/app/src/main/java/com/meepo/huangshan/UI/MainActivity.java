package com.meepo.huangshan.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.meepo.huangshan.R;

public class MainActivity extends AppCompatActivity {
    int a = 1;
    String b = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        b = b + "1";

        TextView MainText_1 = (TextView) findViewById(R.id.Main_text_1);
        if (a == 1) {
            a = a + 1;
            Toast.makeText(this, "Along sapi", Toast.LENGTH_SHORT).show();
            MainText_1.setText(b + "");

        } else if (a == 2) {
            a = a - 1;
            Toast.makeText(this, "tan of long", Toast.LENGTH_SHORT).show();

            MainText_1.setText(b + "");
        }

        if (b.length() == 11) {
            float MainText_1_Size = MainText_1.getTextSize();
            MainText_1.setTextSize(TypedValue.COMPLEX_UNIT_PX,MainText_1_Size - 50);
        }

    }

    public void clear(View view) {
        b = "";
        TextView MainText_1 = (TextView) findViewById(R.id.Main_text_1);
        MainText_1.setText(b + "");
        MainText_1.setTextSize(TypedValue.COMPLEX_UNIT_PX, 100);
    }
}
