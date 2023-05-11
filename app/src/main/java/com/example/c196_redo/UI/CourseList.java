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
import com.example.c196_redo.Entities.Course;
import com.example.c196_redo.R;

import java.util.List;

public class CourseList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        RecyclerView recyclerView=findViewById(R.id.courseRecView);
        Repository repo=new Repository(getApplication());
        List<Course> courses=repo.getAllCourses();
        final CourseAdapter adapter=new CourseAdapter(this);
        adapter.setCourses(courses);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Button bbutton = findViewById(R.id.backBtn);
        bbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Intent intent1 = new Intent(CourseList.this, MainActivity.class);
                startActivity(intent1);
            }
        });

        Button dbutton = findViewById(R.id.detailsBtn);
        dbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Intent intent1 = new Intent(CourseList.this, CourseDetails.class);
                startActivity(intent1);
            }
        });
    }

    public boolean onOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_a_term, menu);
        return true;
    }

    public boolean onOptionsSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

}