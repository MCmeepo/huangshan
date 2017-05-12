package com.meepo.huangshan.UI;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.meepo.huangshan.R;
import com.meepo.huangshan.UI.Adapter.L33MovieAdapter;
import com.meepo.huangshan.bean.ImdbResult;
import com.meepo.huangshan.bean.Movie;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import static android.R.id.content;

public class L32_HttpActiviy extends AppCompatActivity {

    private ListView mMoviesListView;
    private L33MovieAdapter mAdapter;
    private ArrayList<Movie> mData = new ArrayList<>();
    private List<Movie> movies ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l32__http_activiy);

        initview();
    }


    public void start1(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    final String information = requestNetwork();
                    ImdbResult result = ImdbResult.fill(new JSONObject(information));
                    movies = Movie.movieList(result.getSearch());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mAdapter = new L33MovieAdapter(L32_HttpActiviy.this, movies);
                            mMoviesListView.setAdapter(mAdapter);
                        }
                    });
                } catch (JSONException e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(L32_HttpActiviy.this, "JSON异常", Toast.LENGTH_SHORT).show();
                        }
                    });                    e.printStackTrace();
                }catch (UnknownHostException e){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(L32_HttpActiviy.this, "UH异常", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                catch (IOException e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(L32_HttpActiviy.this, "IO异常", Toast.LENGTH_SHORT).show();
                        }
                    });
                    e.printStackTrace();
                }
            }
        }).start();
    }


    public void start2(View view) {
        new AsyncTask<Movie, Movie, String>() {
            @Override
            protected void onPreExecute() {

            }

            @Override
            protected String doInBackground(Movie... params) {
                try {
                    final String information = requestNetwork();
                    ImdbResult result = ImdbResult.fill(new JSONObject(information));
                    movies = Movie.movieList(result.getSearch());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                mAdapter = new L33MovieAdapter(L32_HttpActiviy.this, movies);
                mMoviesListView.setAdapter(mAdapter);
            }
        }.execute();
    }


    private String requestNetwork() throws IOException {
        String urlAddress = "http://www.omdbapi.com?s=Iron Man";                   //建立一个目标地址
        URL url = new URL(urlAddress);                                               //建立一个URL，获取目标地址
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();  //给URL里加一个Http文件
        urlConnection.setConnectTimeout(10 * 1000);                                  //网络超时限制
        urlConnection.setDoInput(true);                                              //输出开启
        int responseCode = urlConnection.getResponseCode();                          //建立一个网络响应代码，网络返回的值赋进去

        if (responseCode == 200) {                                                    //如果返回值是200说明正常
            InputStream inputStream = null;                                          //建立一个空流，准备接收数据
            String result;                                                           //建一个str作为等会返回的结果
            try {
                inputStream = urlConnection.getInputStream();                        //把内容填入流中
                byte[] buffer = new byte[1024];                                      //从流中取内容，放入返回值中并返回
                int len;                                                             //从流中取内容，放入返回值中并返回
                result = "";                                                         //从流中取内容，放入返回值中并返回
                while ((len = inputStream.read(buffer)) != -1) {                     //从流中取内容，放入返回值中并返回
                    result += new String(buffer, 0, len);                            //从流中取内容，放入返回值中并返回
                }                                                                    //从流中取内容，放入返回值中并返回
                return result;                                                       //从流中取内容，放入返回值中并返回
            } catch (IOException e) {                                                //如果开流失败，解决异常
                e.printStackTrace();
            } finally {                                                              //别的方法结束之后要执行finally方法
                if (inputStream != null) {                                           //如果流已经读空了就是关闭流
                    try {
                        inputStream.close();
                    } catch (IOException e) {                                         //抛异常
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }


    private void initview() {
        mMoviesListView = (ListView) findViewById(R.id.l32_lv);

        mMoviesListView.setOnItemClickListener(new OnCardClickListener());
    }


    private class OnCardClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

            Movie movie = (Movie) adapterView.getItemAtPosition(position);

            makePop(movie);

        }
    }


 //  弹出一个pop
    private void makePop(Movie movie){
        LayoutInflater inflater = LayoutInflater.from(this);
        LinearLayout root = new LinearLayout(this);
        View contentView = inflater.inflate(R.layout.l32_popup, root);
        ImageView iv = (ImageView) contentView.findViewById(R.id.l32_pop_iv);
        iv.setImageBitmap(movie.getBitmap());          //放入下载的图片

//        iv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//            }
//        });

        int warp = LinearLayout.LayoutParams.WRAP_CONTENT;
        PopupWindow popupWindow = new PopupWindow(contentView, warp, warp);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
//        popupWindow.showAsDropDown(view, 100, 100);
        popupWindow.showAtLocation(contentView, Gravity.CENTER, 0, 0);
    }



}
