package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResulActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resul);
        TextView show = findViewById(R.id.tvShowBMI);
        double bmi = getIntent().getDoubleExtra("bmi",0);
        if (bmi<18.5) {
            show.setText("體重過輕");
        }
        else if(bmi<=24){
            show.setText("體重正常");
        }
        else {
            show.setText("體重過重");
        }
        //show.setText(String.valueOf(bmi));
    }
}