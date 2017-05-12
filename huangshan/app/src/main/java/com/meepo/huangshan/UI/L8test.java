package com.meepo.huangshan.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.meepo.huangshan.R;
import com.meepo.huangshan.bean.L8test_ninjia;

public class L8test extends AppCompatActivity {

    private TextView L8test_tv1;
    private Button L8test_btn1;
    private Button L8test_btn2;

    private L8test_ninjia player1;
    private L8test_ninjia player2;

    //按钮状态x
    private int state;

    //    更新战斗日志
    private String log = "战斗日志";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l8test);

        initViews();


    }

    public void attack2(View view) {
        state = state + 1;
        if (state == 1) {

            Toast.makeText(this, "你选择了: " + player2.getName(), Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "你不能攻击自己！ ", Toast.LENGTH_SHORT).show();
        }
    }

    public void attack1(View view) {
        if (state > 0) {
            attacking();
        } else {

            Toast.makeText(this, "你不能控制敌方单位: " + player1.getName(), Toast.LENGTH_SHORT).show();
        }

        state = 0;
    }

    public void attacking() {

        if (player1.getHp() > 0 && player2.getHp() > 0) {

            player1.setHp(player1.getHp() - player2.getAttack());
            player2.setHp(player2.getHp() - player1.getAttack());

            log = log +
                    "\n-" + player1.getName() + " 对 " + player2.getName() + " 造成了 " + player1.getAttack() + " 点伤害，"
                    + player2.getName() + " 对 " + player1.getName() + " 造成了 " + player2.getAttack() + " 点伤害，";

            L8test_btn1.setText("玩家名： " + player1.getName() + "(" + player1.getAttack() + "/" + player1.getHp() + ")");
            L8test_btn2.setText("玩家名： " + player2.getName() + "(" + player2.getAttack() + "/" + player2.getHp() + ")");

            L8test_tv1.setText("\n" + log);
        }
        if (player1.getHp() <= 0) {
            log = log + "\n" + player1.getName() + "已战死沙场！";
            L8test_tv1.setText("\n" + log);
            L8test_btn1.setText(player1.getName()+" 已阵亡");

        }
        if (player2.getHp() <= 0) {
            log = log + "\n" + player2.getName() + "已战死沙场！";
            L8test_tv1.setText("\n" + log);
            L8test_btn2.setText(player2.getName()+" 已阵亡");
        }


    }


    public void initViews() {

        L8test_tv1 = (TextView) findViewById(R.id.L8test_tv1);
        L8test_btn1 = (Button) findViewById(R.id.L8test_btn1);
        L8test_btn2 = (Button) findViewById(R.id.L8test_btn2);

        player1 = new L8test_ninjia();
        player1.setName("土土");
        player1.setAttack(3);
        player1.setHp(20);
        L8test_btn1.setText("玩家名： " + player1.getName() + "(" + player1.getAttack() + "/" + player1.getHp() + ")");

        player2 = new L8test_ninjia();
        player2.setName("阿蛋");
        player2.setAttack(4);
        player2.setHp(30);
        L8test_btn2.setText("玩家名： " + player2.getName() + "(" + player2.getAttack() + "/" + player2.getHp() + ")");

        L8test_tv1.setText("请选择人物进行战斗！");
    }

}
