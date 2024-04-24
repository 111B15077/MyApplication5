package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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
        list.add("芭樂");
        list.add("梨子");
        list.add("葡萄");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, list);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner SpFrulit = findViewById(R.id.SpFrulit);
        TextView tvshow1 = findViewById(R.id.tvshow1);
        ListView lvfruit = findViewById(R.id.lvFruit);

        lvfruit.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        lvfruit.setAdapter(adapter);
//        SpFrulit.setAdapter(adapter);
        lvfruit.setAdapter(adapter);
//我不是要幾項，而是顯示有那些物品 例如點了蘋果 香蕉
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

        lvfruit.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 获取ListView的选中状态
                SparseBooleanArray checked = lvfruit.getCheckedItemPositions();
                StringBuilder selectedItems = new StringBuilder();
                for (int i = 0; i < checked.size(); i++) {
                    // 如果该项被选中，则增加到selectedItems
                    if (checked.valueAt(i)) {
                        selectedItems.append(list.get(i)).append("、");
                    }
                }
                // 移除最后一个顿号
                if (selectedItems.length() > 0) {
                    selectedItems.deleteCharAt(selectedItems.length() - 1);
                }
                // 更新tvshow1的文本
                tvshow1.setText("你選擇了: " + selectedItems.toString());
            }
        });

        lvfruit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tvshow1.setText(list.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                tvshow1.setText("請選擇水果");
            }
        });
    }
}