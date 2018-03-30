package com.example.qinjunhong.letter;

import android.app.*;

import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        /*FragmentManager fm=getFragmentManager();
        android.app.FragmentTransaction transaction=fm.beginTransaction();
        transaction.replace(R.id.frambutton,new ButtonFragment());
        transaction.replace(R.id.framlist,new ListFragment());
        //提交事务
        transaction.commit();*/
        getSupportFragmentManager().beginTransaction().add(R.id.framlist,new ListFragment()).commit();//R.id.container 为启动该Fragment的Activity的id
        getSupportFragmentManager().beginTransaction().add(R.id.frambutton,new ButtonFragment()).commit();
    }
    public void btnMail(View view){
        getSupportFragmentManager().beginTransaction().replace(R.id.framlist,new ListFragment()).commit();
    }
    public void btnMy(View view){
        getSupportFragmentManager().beginTransaction().replace(R.id.framlist,new MyFragment()).commit();
    }


}
