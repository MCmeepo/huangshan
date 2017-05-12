package com.meepo.huangshan.teach;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.meepo.huangshan.R;
import com.meepo.huangshan.bean.Dog;
import com.meepo.huangshan.bean.HsToast;

public class L12ClassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l12_class);
        System.out.println("HS Activity 的 onCreate 方法执行了");
        Dog dog2 = new Dog("xiao hua");
        Dog.sFood = 2;
        Dog dog3 = new Dog("xiao huang");
        Dog.sFood = 3;
        Dog dog4 = new Dog("xiao hei");
        Dog.sFood = 4;
        System.out.println("HS 4sFood = " + Dog.getFood());
        Dog.setFood(33);
        HsToast.sShow(this, "黄山人的 toast");
        Dog dog = Dog.craeteStupidDog();
    }
}
