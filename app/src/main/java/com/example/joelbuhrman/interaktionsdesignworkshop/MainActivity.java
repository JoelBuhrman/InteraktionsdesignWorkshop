package com.example.joelbuhrman.interaktionsdesignworkshop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void startAccActivity(View view){
        startActivity(new Intent(this, AccActivity.class));
    }
    public void startCompass(View view){
        startActivity(new Intent(this, Compass.class));
    }



}
