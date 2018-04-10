package com.example.qinjunhong.letter;

import android.app.*;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public abstract class MainActivity extends AppCompatActivity
        implements View.OnClickListener {
    // 登陆按钮
    private Button logbtn;
    private Button regbtn;


    // 显示用户名和密码
    EditText username, password;
    // 创建等待框
    private ProgressDialog dialog;
    // 返回的数据
    private String info;
    // 返回主线程更新数据
    private static Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText) findViewById(R.id.editUsername);
        password = (EditText) findViewById(R.id.editPassword);
        logbtn = (Button) findViewById(R.id.buttonLogin);
        regbtn = (Button) findViewById(R.id.buttonSign);

        logbtn.setOnClickListener(this);
        regbtn.setOnClickListener(this);

    }
    public void btnLogin(View view){
        if (!checkNetwork()) {
            Toast toast = Toast.makeText(this,"please check internet", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();

        }
        else{
            dialog = new ProgressDialog(this);
            dialog.setTitle("");
            dialog.setMessage("Logining...");
            dialog.setCancelable(false);
            dialog.show();
            new Thread(new MyThread()).start();

        }
    }
    public void btnSignup(View view)
    {
        if (!checkNetwork()) {
            Toast toast = Toast.makeText(this,"please check internet", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();

        }
        else{
            dialog = new ProgressDialog(this);
            dialog.setTitle("");
            dialog.setMessage("Signing");
            dialog.setCancelable(false);
            dialog.show();
            new Thread(new MyThread()).start();

        }
    }

    // 子线程接收数据，主线程修改数据
    public class MyThread implements Runnable {
        @Override
        public void run() {
            info = WebService.executeHttpGet(username.getText().toString(), password.getText().toString());
            // info = WebServicePost.executeHttpPost(username.getText().toString(), password.getText().toString());
            handler.post(new Runnable() {
                @Override
                public void run() {
                   // infotv.setText(info);
                    dialog.dismiss();
                    Intent intent = new Intent(MainActivity.this, ListActivity.class);
                    startActivity(intent);
                    MainActivity.this.finish();
                }
            });
        }
    }
    private boolean checkNetwork() {
        ConnectivityManager connManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connManager.getActiveNetworkInfo() != null) {
            return connManager.getActiveNetworkInfo().isAvailable();
        }
        return false;
    }
}
