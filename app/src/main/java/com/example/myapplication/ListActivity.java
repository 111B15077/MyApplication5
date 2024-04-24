package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class ListActivity extends AppCompatActivity {
//    private Spinner SpFrulit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        List<String> list = new ArrayList<>();
        list.add("蘋果");
        list.add("香蕉");
        list.add("橘子");
        list.add("西瓜");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner SpFrulit = findViewById(R.id.SpFrulit);
        TextView tvshow1 = findViewById(R.id.tvshow1);
        SpFrulit.setAdapter(adapter);

        SpFrulit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tvshow1.setText("你選擇了" + parent.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                tvshow1.setText("請選擇水果");
            }
        });
    }
}