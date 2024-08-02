package com.example.project.Activity;


import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.Adapter.RecyclerViewAdapter;
import com.example.project.Models.ExamCode;
import com.example.project.R;
import java.util.ArrayList;

public class SelectExamCodeActivity extends AppCompatActivity {
    ArrayList<ExamCode> examCodes;
    RecyclerView recyclerView;

    private void bindingView(){
        recyclerView = findViewById(R.id.recyclerView);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_select_exam_code);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.selectExamCode), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        bindingView();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        examCodes = new ArrayList<>();
        examCodes.add(new ExamCode(R.drawable.storytelling,"Đề 1"));
        examCodes.add(new ExamCode(R.drawable.storytelling,"Đề 2"));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(examCodes, this);
        recyclerView.setAdapter(adapter);
    }
}