package com.example.qinjunhong.letter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        getSupportFragmentManager().beginTransaction().add(R.id.framwrite,new WriteFragment()).commit();
    }
    public void btnWrSend(View view){
        getSupportFragmentManager().beginTransaction().replace(R.id.framwrite,new SendFragment()).commit();
    }
    public void btnWrSave(View view)
    {
        Intent intent = new Intent(WriteActivity.this,ListActivity.class);
        startActivity(intent);
    }
}
