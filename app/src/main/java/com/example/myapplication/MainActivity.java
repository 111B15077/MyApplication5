package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView show;
    private EditText height;
    private EditText weight;
    private RadioGroup rbsex;
    private CheckBox apple;
    private CheckBox banana;
    private CheckBox orange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();

        myListener();
    }

    private void myListener() {
        rbsex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rbMale) {
                    show.setText("我是男生");
                } else if (checkedId == R.id.rbFemale) {
                    show.setText("我是女生");
                }
            }
        });
        apple.setOnCheckedChangeListener((buttonView, isChecked) -> getFruits());
        banana.setOnCheckedChangeListener((buttonView, isChecked) -> getFruits());
        orange.setOnCheckedChangeListener((buttonView, isChecked) -> getFruits());
    }

    private void getFruits() {
        String msg = "";
        if (apple.isChecked()) {
            msg += "蘋果";
        } if (banana.isChecked()) {
            msg += "香蕉";
        } if (orange.isChecked()) {
            msg += "橘子";
        }
        show.setText("我喜歡吃"+msg);
    }

    public void showDialog(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("BMI");
        double bmi = getBmi();
        String result = getString(R.string.strshowbmi) + String.valueOf(bmi);
        builder.setMessage(result);
        builder.setPositiveButton("OK", null);
        builder.show();

    }

    public void calcBMI(View view) {
        DecimalFormat df = new DecimalFormat("#.00");

        double bmi = getBmi();
        String result  = getString(R.string.strshowbmi) + String.valueOf(bmi);
//        show.setText(result);
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();

    }

    private double getBmi() {
        DecimalFormat df = new DecimalFormat("#.00");
        double h = Double.parseDouble(height.getText().toString());
        double w = Double.parseDouble(weight.getText().toString());
        double bmi = w / (h/100.0 * h/100.0);
        bmi = Double.parseDouble(df.format(bmi));
        return bmi;
    }

    public void goNext(View view) {
        Intent intent = new Intent(this, ResulActivity.class);
        double bmi = getBmi();
        intent.putExtra("bmi", bmi);
        startActivity(intent);
    }

    private void findViews() {
        height = findViewById(R.id.etHeight);
        weight = findViewById(R.id.etweight);
        show = findViewById(R.id.tvshow);

        rbsex = findViewById(R.id.rbsex);

        apple = findViewById(R.id.cbapple);
        banana = findViewById(R.id.cbbanana);
        orange = findViewById(R.id.cborange);
    }

}
