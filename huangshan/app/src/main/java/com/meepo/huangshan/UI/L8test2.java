package com.meepo.huangshan.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.meepo.huangshan.R;
import com.meepo.huangshan.bean.L8test_ninjia;

import java.util.Random;

public class L8test2 extends AppCompatActivity {

    private TextView tv_log;

    private Button btn_player1;
    //    private Button btn_player12;
    private Button btn_enemy1;
    private Button btn_enemy2;


    private L8test_ninjia player1;
    private L8test_ninjia player2;
    private L8test_ninjia enemy1;
    private L8test_ninjia enemy2;

    private int state;
    private int died;

    private String log = "战斗日志";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l8test2);
//        载入控件，创建人物
        initViews();
    }

    public void onPlayer1(View view) {
        if (player1.getHp() > 0) {
            state = state + 1;
            makeToast(player1);
        } else {
            state = 0;
            makeToast(player1);
        }

    }

    public void onEnemy1(View view) {
        if (state > 0) {
            attacking(player1, enemy1);
            updataLog(player1, enemy1, enemy2);
            updataButtnText(player1, btn_player1);
            updataButtnText(enemy1, btn_enemy1);
            state = state - 1;
        } else {
            state = 0;
            makeToast(enemy1);
        }
    }

    public void onEnemy2(View view) {
        if (state > 0) {
            attacking(player1, enemy2);
            updataLog(player1, enemy2, enemy1);
            updataButtnText(player1, btn_player1);
            updataButtnText(enemy2, btn_enemy2);
            state = 0;
        } else {
            state = 0;
            makeToast(enemy2);
        }
    }

    public void clearLog(View view) {
        log = "";
        tv_log.setText(log);
    }

    public void attacking(L8test_ninjia newplayer1, L8test_ninjia newplayer2) {
        if (newplayer1.getHp() > 0 && newplayer2.getHp() > 0) {
            newplayer1.setHp(newplayer1.getHp() - newplayer2.getAttack());
            newplayer2.setHp(newplayer2.getHp() - newplayer1.getAttack());
            return;
        }
        if (newplayer1.getHp() > 0 && newplayer2.getHp() <= 0) {
            Toast.makeText(this, "你不能攻击死人！", Toast.LENGTH_SHORT).show();
            return;
        }

    }

    public void makeToast(L8test_ninjia newplayer) {
        if (newplayer.getHp() > 0) {
            if (state == 1) {
                Toast.makeText(this, "你选择了: " + newplayer.getID() + " 号玩家 " + newplayer.getName(), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "你不能控制敌方单位", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "你不能控制死人", Toast.LENGTH_SHORT).show();
        }
    }

    public void initViews() {

        tv_log = (TextView) findViewById(R.id.L8test2_tv1);
        btn_player1 = (Button) findViewById(R.id.L8test2_player1);
//        btn_player2 = (Button) findViewById(R.id.L8test_btn2);
        btn_enemy1 = (Button) findViewById(R.id.L8test2_enemy1);
        btn_enemy2 = (Button) findViewById(R.id.L8test2_enemy2);

        player1 = new L8test_ninjia();
        player1.setID(1);
        player1.setName("土土");
        player1.setAttack(new Random().nextInt(10));
        player1.setHp(new Random().nextInt(10) + 20);
        updataButtnText(player1, btn_player1);

//        player2 = new L8test_ninjia();
//        player2.setID(1);
//        player2.setName("土土");
//        player2.setAttack(3);
//        player2.setHp(20);

        enemy1 = new L8test_ninjia();
        enemy1.setID(3);
        enemy1.setName("阿蛋1");
        enemy1.setAttack(new Random().nextInt(10));
        enemy1.setHp(new Random().nextInt(10) + 10);
        updataButtnText(enemy1, btn_enemy1);

        enemy2 = new L8test_ninjia();
        enemy2.setID(4);
        enemy2.setName("阿蛋2");
        enemy2.setAttack(new Random().nextInt(10));
        enemy2.setHp(new Random().nextInt(10) + 10);
        updataButtnText(enemy2, btn_enemy2);

        tv_log.setText("请选择人物进行战斗！");

    }

    public void updataLog(L8test_ninjia newplayer1, L8test_ninjia newplayer2, L8test_ninjia newplayer3) {
        if (newplayer1.getHp() > 0 && newplayer2.getHp() > 0) {
            log = log +
                    "\n-" + newplayer1.getName() + " 对 " + newplayer2.getName() + " 造成 " + newplayer1.getAttack() + " 点伤害，"
                    + newplayer2.getName() + " 对 " + newplayer1.getName() + " 造成 " + newplayer2.getAttack() + " 点伤害。";

        }
        if (newplayer1.getHp() > 0 && newplayer2.getHp() <= 0) {
            if (newplayer3.getHp() <= 0) {
                log = log +
                        "\n-" + "你赢了！";
            } else {
                log = log + "\n-" + newplayer2.getName() + "已经躺了！";
            }

        }
        if (newplayer1.getHp() <= 0) {
            if (newplayer2.getHp() <= 0 && newplayer3.getHp() <= 0) {
                log = log +
                        "\n-" + "你们同归于尽了！";
            } else {
                log = log +
                        "\n-" + "你输了！";
            }

        }

        tv_log.setText(log);
    }

    public void updataButtnText(L8test_ninjia newplayer, Button newbtn) {
        if (newplayer.getHp() > 0) {
            newbtn.setText(newplayer.getName()
                    + "(" + newplayer.getAttack() + "/" + newplayer.getHp() + ")");
        } else {
            newbtn.setText(newplayer.getName() + " was died");
        }
    }

}
