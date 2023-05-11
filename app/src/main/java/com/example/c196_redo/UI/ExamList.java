package com.example.c196_redo.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c196_redo.Database.Repository;
import com.example.c196_redo.Entities.Exam;
import com.example.c196_redo.R;

import java.util.List;

public class ExamList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        RecyclerView recyclerView=findViewById(R.id.examRecView);
        Repository repo=new Repository(getApplication());
        List<Exam> exams=repo.getAllExams();
        final ExamAdapter adapter=new ExamAdapter(this);
        adapter.setExams(exams);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Button bbutton = findViewById(R.id.backBtn);
        bbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Intent intent1 = new Intent(ExamList.this, MainActivity.class);
                startActivity(intent1);
            }
        });

        Button dbutton = findViewById(R.id.detailsBtn);
        dbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Intent intent1 = new Intent(ExamList.this, ExamDetails.class);
                startActivity(intent1);
            }
        });

    }

    public boolean onOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_a_term, menu);
        return true;
    }

    public boolean onOptionsSelected(MenuItem item) {

                return true;

    }

}