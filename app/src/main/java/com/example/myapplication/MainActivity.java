package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calcBMI(View view) {
        DecimalFormat df = new DecimalFormat("0.00");
        EditText height = findViewById(R.id.etHeight);
        EditText weight = findViewById(R.id.etweight);
        double h = Double.parseDouble(height.getText().toString());
        double w = Double.parseDouble(weight.getText().toString());

        double bmi = w / (h / 100.0 * h / 100.0);
        bmi = Double.parseDouble(df.format(bmi));
        String result = getString(R.string.strshowbmi) + bmi;
        TextView show = findViewById(R.id.tvshow);
        show.setText(result);
    }

    public void goNext(View view) {
        Intent intent = new Intent(this, ResulActivity.class);
        startActivity(intent);
    }
}
