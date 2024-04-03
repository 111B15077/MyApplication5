package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ResulActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resul);
        ImageView img = findViewById(R.id.ivshow);

        TextView show = findViewById(R.id.tvshowbmi);
        double bmi = getIntent().getDoubleExtra("bmi", 0);
        if (bmi < 18.5) {
            show.setText("體重過輕");
            img.setImageResource(R.drawable.a1);
        } else if (bmi <= 24) {
            show.setText("體重正常");
            img.setImageResource(R.drawable.a2);
        } else if (bmi > 24){
            show.setText("體重過重");
            img.setImageResource(R.drawable.a3);
        }
        //        show.setText(String.valueOf(bmi));
    }
    public void onback(android.view.View view) {
        finish();
    }
}