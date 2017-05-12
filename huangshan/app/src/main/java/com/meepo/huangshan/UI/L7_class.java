package com.meepo.huangshan.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.meepo.huangshan.R;
import com.meepo.huangshan.bean.drink;

public class L7_class extends AppCompatActivity {
    int x;
    drink[] drinks = new drink[5];
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l7_class);

        loading();

    }

    public void toast(View view) {

        Toast.makeText(this, "品牌： " + drinks[x].name
                + "\n容量： " + drinks[x].capacity
                + "\n颜色： " + drinks[x].color, Toast.LENGTH_SHORT).show();


        image.setImageResource(drinks[x].imageID);

        x = x + 1;
        if (x ==2){
            x = x - 2;
        }
    }

    public void loading() {
        drink drinkA = new drink();
        drinkA.name = "可口可乐";
        drinkA.capacity = 550;
        drinkA.color = "黑";
        drinkA.imageID = R.mipmap.l6_1;
        drinks[0] = drinkA;

        drink drinkB = new drink();
        drinkB.name = "冰峰";
        drinkB.capacity = 330;
        drinkB.color = "黄";
        drinkB.imageID = R.mipmap.l6_2;
        drinks[1] = drinkB;

        image = (ImageView) findViewById(R.id.L7_iv);
    }
}
