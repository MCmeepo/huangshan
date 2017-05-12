package com.meepo.huangshan.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.meepo.huangshan.R;
import com.meepo.huangshan.bean.Tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class L23File extends AppCompatActivity {


    private TextView ml23_tv;
    private EditText ml23_ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l23_file);

//这个记一下     数据大小的单位和换算
        // 1 2 4 8 16 32 64 128 256 512 1024
        // byte
        // 1k = 1024 byte
        // 1 byte = 8 bit（位）
        // 00000001 = 1 = 2^0
        // 00000010 = 2 = 2^1
        // 00000100 = 4 = 2^2
        // 00001000 = 8 = 2^3
        // 00001010 = 8 + 2 = 10
        // 00001111 = 8 + 4 + 2 + 1 = 15
        // 10000000 = 128 = 2^7
        // 11111111 = 255 = 2^8 - 1
        // 0 1111111
        // 1 1111111
        //100000000 = 2^8
        // 'a' 的大小是一个 byte
        // Byte.MAX_VALUE == 2^7 - 1
        // Integer.MAX_VALUE = 2^31 - 1 = 2^7 * 2^8 * 2^8 * 2^8 - 1;
        // 01111111 11111111 11111111 11111111 = 2^31 - 1
        // 11111111 11111111 11111111 11111111 = 2^32 - 1
        //1 00000000 00000000 00000000 00000000 = 2^32
        // 一个 int 型，占 4 个 byte
        // int a = 1;

        initView();
    }

    public void savename(View view) {
        Editable editable = ml23_ed.getText();
        String name = editable.toString();
        // 获取 sdCard 上本应用的缓存路径
        File extCacheDir = getExternalCacheDir();
        // 在以上路径中，新建一个名为 L23.txt 的文件
        File file = new File(extCacheDir, "name.txt");
//         储存文字的固定用法
//        建立一个输出流，由app输出至手机内存
//        使用完毕后关闭流
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(file);
            out.write(name.getBytes());        //写入文字
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (out != null) {
                out.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadname(View view) {
        File extCacheDir = getExternalCacheDir();         //建立一个路径extCacheDir
        File file = new File(extCacheDir, "name.txt");     //读取路径extCacheDir上的文件："name.txt"
        byte[] bytes = new byte[1024];                     //建立一个建立一个字节数组，等下要把流中的数据写入字节数组中
        FileInputStream in = null;                        //建立一个输入流in（由手机内存输入至app）；
        try {                                             //
            in = new FileInputStream(file);               //把读取到的文件放入流中
            int length = in.read(bytes);                   //读取数据，计算长度
            Toast.makeText(this, "len: " + length, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (in != null) {
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String name = new String(bytes);                  //建立一个string文件赋值为字节数组里的内容
        ml23_tv.setText(name);
    }


    public void load(View v) {
        File extCacheDir = getExternalCacheDir();
        File file = new File(extCacheDir, "name.txt");
        byte[] bytes = new byte[20];                         //建立一个建立一个字节数组，等下要把每次读取的流中的数据写入字节数组中
        FileInputStream in = null;
        String content = "";                                //最后输出的字符串
        try {
            in = new FileInputStream(file);
            int len;
            while ((len = in.read(bytes)) != -1) {          //做一个循环，如果储存器中还有数据，则继续读取
                String currentContent = new String(bytes, 0, len);         //建立一个临时字符串，将每次读取出来的内容存入
                content = content + currentContent;     //每次循环都加上临时字符串
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Tools.closeStream(in);                          //调取关闭流的方法
        ml23_tv.setText(content);
    }



    private void initView() {
        ml23_tv = (TextView) findViewById(R.id.l23_tv);
        ml23_ed = (EditText) findViewById(R.id.l23_ed);
    }
}
