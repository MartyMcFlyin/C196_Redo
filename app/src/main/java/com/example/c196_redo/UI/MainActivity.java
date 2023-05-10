package com.example.c196_redo.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.c196_redo.Database.Repository;
import com.example.c196_redo.Entities.Course;
import com.example.c196_redo.Entities.Exam;
import com.example.c196_redo.Entities.Term;
import com.example.c196_redo.R;

import java.util.UUID;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button tbutton = findViewById(R.id.termBtn);
        tbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Intent intent1 = new Intent(MainActivity.this, TermList.class);
                startActivity(intent1);
            }
        });

        Button cbutton = findViewById(R.id.courseBtn);
        cbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                Intent intent2 = new Intent(MainActivity.this, CourseList.class);
                startActivity(intent2);
            }
        });

        Button ebutton = findViewById(R.id.examBtn);
        ebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v3) {
                Intent intent3 = new Intent(MainActivity.this, ExamList.class);
                startActivity(intent3);
            }

        });


        String random = UUID.randomUUID().toString();
        Term term = new Term(0, random, "1/1/2024", "1/2/2024", "Yada Yada Yada");
        Course course = new Course(0, random, "2/1/2024", "2/2/2024", "Yuda Yuda Yuda");
        Exam exam = new Exam(0, random, "3/1/2024", "3/2/2024", "Yoa Yoda Yoda");
        Repository repository = new Repository(getApplication());

        //aDD A SET OF DATA TO THE DB
     //   repository.insertTerm(term);
     //   repository.insertCourse(course);
     //   repository.insertExam(exam);


    }

    //Final }
}