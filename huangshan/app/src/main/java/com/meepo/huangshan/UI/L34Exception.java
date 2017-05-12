package com.meepo.huangshan.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.meepo.huangshan.R;
import com.meepo.huangshan.UI.Exception.EmptyManaException;

public class L34Exception extends AppCompatActivity {


    private TextView mLogTextView;
    private int mManaCount = 8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l34_exception);

        mLogTextView = (TextView) findViewById(R.id.l34_tv_log);
    }

    private void log(String msg) {
        // append 会将新内容追加到老内容中
        mLogTextView.append(" - " + msg + "\n\n");
    }


    // NullPointerException  赋值为空会报错的用，空指针异常
    public void catchNull(View view) {
        try {
            String a = getHeroName();
            char initialA = a.charAt(0);
            log("catchNull 获取到首字母：" + initialA);
            String b = getHeroName();
            char initialB = b.charAt(0);
            log("catchNull 获取到首字母：" + initialB);
            String c = getHeroName();
            char initialC = c.charAt(0);
            log("catchNull 获取到首字母：" + initialC);
        } catch (NullPointerException e) {
            e.printStackTrace();
            log("catchNull 捕获到空指针异常");
        }
    }

    private String getHeroName() {
        return null;
    }


    //算术异常：发现有可能出现算数错误的地方加，算术异常，如可能出现的除0运算
    public void catchArithmetic(View view) {
        try {
            int a = 4;
            int b = 0;
            int c = a / b;
            log("catchArithmetic c: " + c);
        } catch (ArithmeticException e) {
            log("捕获到算数异常： 除0运算");
            e.printStackTrace();
        }
    }


    //在可能出错的地方建立自定义异常
    public void catchCustom(View view) {
        try {
            playCardParent();
            log("catchCustom mana: " + mManaCount);
        } catch (EmptyManaException e) {
            e.printStackTrace();
            log("catchCustom 捕获到空水晶异常（自定义异常）");
            Toast.makeText(this, "没水晶了", Toast.LENGTH_SHORT).show();
        }
    }


    private int playCardParent() throws EmptyManaException {
        return playCard();
    }

    private int playCard() throws EmptyManaException {
        if (mManaCount <= 0) {
            throw new EmptyManaException("你没有法力水晶了");
        }
        // 打出卡牌
        int currentCardCost = 4;
        if (mManaCount >= currentCardCost) {
            mManaCount = mManaCount - currentCardCost;
        }
        return mManaCount;
    }


    //数组月结异常：主要用于不定数组的判断，调取的数组编号大于数组的项数
    public void catchIndexOut(View view) {
        try {
            int[] array = new int[3];
            array[0] = 0;
            array[1] = 1;
            array[2] = 2;
            int result = 1 + array[3];
            log("catchIndexOut result: " + result);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            log("catchIndexOut 捕获到数组越界异常");
        }
    }
}
