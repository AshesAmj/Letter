package com.example.qinjunhong.letter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RecevieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recevie);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragrece,new RecevieFragment()).commit();
    }
    public void btnreply(View view)
    {
        Intent intent = new Intent(RecevieActivity.this, WriteActivity.class);
        startActivity(intent);
    }

}
