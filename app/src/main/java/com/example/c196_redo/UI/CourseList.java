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

    private Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);

        Repository repo = new Repository(getApplication());
        List<Course> allCourses = repo.getAllCourses();
        RecyclerView recyclerView = findViewById(R.id.courseRecView);
        final CourseAdapter courseAdapter = new CourseAdapter(this);
        recyclerView.setAdapter(courseAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        courseAdapter.setCourses(allCourses);

        Button bbutton = findViewById(R.id.backBtn);
        bbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Intent intent1 = new Intent(CourseList.this, MainActivity.class);
                startActivity(intent1);
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_a_course, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
//                Intent intent=new Intent(CourseDetails.this,MainActivity.class);
//                startActivity(intent);
                return true;

            case R.id.addCourse:
                //   Repository repo = new Repository(getApplication());

                //aDD A SET OF DATA TO THE DB

                // List<Course> allCourses=repository.getAllCourses();
                //  RecyclerView recyclerView=findViewById(R.id.courseRecView);
                //    final CourseAdapter courseAdapter=new CourseAdapter(this);
                //    recyclerView.setAdapter(courseAdapter);
                //     recyclerView.setLayoutManager(new LinearLayoutManager(this));
                //    courseAdapter.setCourses(allCourses);

                Intent intent5 = new Intent(CourseList.this, CourseDetails.class);
                startActivity(intent5);

                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Repository repo = new Repository(getApplication());
        List<Course> allCourses = repo.getAllCourses();
        RecyclerView recyclerView = findViewById(R.id.courseRecView);
        final CourseAdapter courseAdapter = new CourseAdapter(this);
        recyclerView.setAdapter(courseAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        courseAdapter.setCourses(allCourses);

    }

}