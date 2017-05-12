package com.meepo.huangshan.UI;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.meepo.huangshan.R;

public class L29Progress extends AppCompatActivity {

    //    TextView mtv1;
//    TextView mlog;
//    TextView mhptv;
//
    ProgressBar mCD1;
    ProgressBar mCD2;
    ProgressBar mCD3;

    //    String mHP1;
//    String mHP2;
//    String mLog;
//
//    int mhp1;
//    int mhp2;
    int mcd1;
    int mcd2;
    int mcd3;
    int mPbCd =1000;

    int mdialogmessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l29_progress);

        initView();
        attackTime3();
        attackTime1();
        attackTime2();
    }


    public void attack(View view) {
        if (mcd1 < 1000 || mPbCd < 1000) {
            Toast.makeText(L29Progress.this, "你还没有准备好！！", Toast.LENGTH_SHORT).show();
        } else {
            mcd1 = 0;
            mPbCd = 0;
            publicCooddown();
            attackTime1();
        }
    }

    public void attack2(View view) {
        if (mcd2 < 1000 || mPbCd < 1000) {
            Toast.makeText(L29Progress.this, "你还没有准备好！！", Toast.LENGTH_SHORT).show();
        } else {
            mcd2 = 0;
            mPbCd = 0;
            publicCooddown();
            attackTime2();
        }
    }


    public void popupProgressDialog(View view) {
        new AsyncTask<String, Void, String>() {
            ProgressDialog dialog;      //弹窗进度条

            @Override
            protected void onPreExecute() {
                dialog = new ProgressDialog(L29Progress.this);
                dialog.setCancelable(true);                     //可以点旁边取消
                dialog.setTitle("死机");
                dialog.setMessage("0");
                dialog.show();
//                dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
//                    @Override
//                    public void onCancel(DialogInterface dialog) {
//
//                    }
//                });
            }

            @Override
            protected String doInBackground(String... params) {
                sleepData(3000);

                while (mdialogmessage < 3000) {
                    sleepData(1);
                    mdialogmessage++;
                }
                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                dialog.dismiss();           //消失
//                dialog.cancel();           取消
            }
        }.execute();
    }

    //匿名内部类开线程
    private void oldAttack() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mcd2 < 1000) {
                    sleepData(2);
                    mcd2++;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mCD2.setProgress(mcd2);
                        }
                    });
                }
                ;
            }
        }).start();
    }

    //asytask开线程 针对进度条控件 用asy
    public void attackTime2() {
        AsyncTask<String, Integer, Integer> asyncTask = new AsyncTask<String, Integer, Integer>() {
            @Override
            protected void onPreExecute() {
            }

            @Override
            protected Integer doInBackground(String... params) {
                while (mcd2 < 1000) {
                    sleepData(3);
                    mcd2++;
                    publishProgress(mcd2);
                }
                return mcd2;
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                mCD2.setProgress(values[0]);
            }

            @Override
            protected void onPostExecute(Integer result) {
            }
        };
        asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "start");
    }

    public void attackTime1() {
        AsyncTask<String, Integer, Integer> asyncTask = new AsyncTask<String, Integer, Integer>() {
            @Override
            protected void onPreExecute() {
            }

            @Override
            protected Integer doInBackground(String... params) {
                while (mcd1 < 1000) {
                    sleepData(2);
                    mcd1++;
                    publishProgress(mcd1);
                }
                return mcd1;
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                mCD1.setProgress(values[0]);
            }

            @Override
            protected void onPostExecute(Integer result) {
            }
        };
        asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "start");
    }

    public void attackTime3() {
        AsyncTask<String, Integer, Integer> asyncTask = new AsyncTask<String, Integer, Integer>() {
            @Override
            protected void onPreExecute() {
            }

            @Override
            protected Integer doInBackground(String... params) {
                while (mcd3 < 1000) {
                    sleepData(1);
                    mcd3++;
                    publishProgress(mcd3);
                    if(mcd3 == 1000){
                        mcd3=0;
                    }
                }
                return mcd3;
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                mCD3.setProgress(values[0]);
            }

            @Override
            protected void onPostExecute(Integer result) {
            }
        };
        asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "start");
    }


    public void publicCooddown() {
        AsyncTask<String, Integer, Integer> asyncTask = new AsyncTask<String, Integer, Integer>() {
            @Override
            protected void onPreExecute() {
            }

            @Override
            protected Integer doInBackground(String... params) {
                while (mPbCd < 1000) {
                    sleepData(1);
                    mPbCd = mPbCd+2;
                    publishProgress(mPbCd);
                }
                return mPbCd;
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                mCD1.setSecondaryProgress(values[0]);
                mCD2.setSecondaryProgress(values[0]);
            }

            @Override
            protected void onPostExecute(Integer result) {
            }
        };
        asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "start");
    }

    private void sleepData(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void initView() {
        mCD1 = (ProgressBar) findViewById(R.id.l29_pb_cd1);
        mCD2 = (ProgressBar) findViewById(R.id.l29_pb_cd2);
        mCD3 = (ProgressBar) findViewById(R.id.l29_pb_cd3);
        mCD1.setMax(1000);
        mCD2.setMax(1000);
        mCD3.setMax(1000);
    }
}
