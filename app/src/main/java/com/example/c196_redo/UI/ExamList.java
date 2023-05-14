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

    private Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_list);

        Repository repo = new Repository(getApplication());
        List<Exam> allExams = repo.getAllExams();
        RecyclerView recyclerView = findViewById(R.id.examRecView);
        final ExamAdapter examAdapter = new ExamAdapter(this);
        recyclerView.setAdapter(examAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        examAdapter.setExams(allExams);

        Button bbutton = findViewById(R.id.backBtn6);
        bbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Intent intent1 = new Intent(ExamList.this, MainActivity.class);
                startActivity(intent1);
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_a_exam, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
//                Intent intent=new Intent(ExamDetails.this,MainActivity.class);
//                startActivity(intent);
                return true;

            case R.id.addExam:
                Repository repo = new Repository(getApplication());

                //aDD A SET OF DATA TO THE DB

                //    List<Exam> allExams=repository.getAllExams();
                //    RecyclerView recyclerView=findViewById(R.id.examRecView);
                //    final ExamAdapter examAdapter=new ExamAdapter(this);
                //    recyclerView.setAdapter(examAdapter);
                //    recyclerView.setLayoutManager(new LinearLayoutManager(this));
                //    examAdapter.setExams(allExams);

                Intent intent5 = new Intent(ExamList.this, ExamDetails.class);
                startActivity(intent5);

                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Repository repo = new Repository(getApplication());
        List<Exam> allExams = repo.getAllExams();
        RecyclerView recyclerView = findViewById(R.id.examRecView);
        final ExamAdapter examAdapter = new ExamAdapter(this);
        recyclerView.setAdapter(examAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        examAdapter.setExams(allExams);

    }

}