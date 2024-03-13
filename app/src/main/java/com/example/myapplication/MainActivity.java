package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calcBMI(View view) {
        EditText height = findViewById(R.id.etHeight);
        EditText weight = findViewById(R.id.etweight);
        double h = Double.parseDouble(height.getText().toString());
        double w = Double.parseDouble(weight.getText().toString());
        double bmi = w / (h/100.0 * h/100.0);
        String result = "你的BMI是 " + bmi;
        TextView show = findViewById(R.id.tvshow);
        show.setText(result);
    }
}