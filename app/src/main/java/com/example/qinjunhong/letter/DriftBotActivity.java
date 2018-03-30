package com.example.qinjunhong.letter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DriftBotActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drift_bot);
        getSupportFragmentManager().beginTransaction().add(R.id.fragdrbot,new DriftBotFragment()).commit();
    }
    public void btnreply(View view)
    {
        Intent intent = new Intent(DriftBotActivity.this, WriteActivity.class);
        startActivity(intent);
    }
}
