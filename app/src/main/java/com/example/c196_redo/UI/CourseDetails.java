package com.example.c196_redo.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c196_redo.Database.Repository;
import com.example.c196_redo.Entities.Course;
import com.example.c196_redo.Entities.Exam;
import com.example.c196_redo.R;

import java.util.ArrayList;
import java.util.List;

public class CourseDetails extends AppCompatActivity {

    Repository repository;
    EditText ecourseStart;
    EditText ecourseID;
    EditText ecourseEnd;
    EditText editName;
    EditText ecourseNotes;
    String notes;
    String start;
    String end;
    String name;
    int id;
    Course currentCourse;
    int numExams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);

        name = getIntent().getStringExtra("name");
        editName = findViewById(R.id.courseName);
        editName.setText(name);

        notes = getIntent().getStringExtra("notes");
        ecourseNotes = findViewById(R.id.courseNotes);
        ecourseNotes.setText(notes);

        start = getIntent().getStringExtra("start");
        ecourseStart = findViewById(R.id.courseStart);
        ecourseStart.setText(start);

        end = getIntent().getStringExtra("end");
        ecourseEnd = findViewById(R.id.courseEnd);
        ecourseEnd.setText(end);

        id = getIntent().getIntExtra("id", -1);
        ecourseID = findViewById(R.id.courseID);
        ecourseID.setText(String.valueOf(id));

        RecyclerView recyclerView = findViewById(R.id.examRecView);
        repository = new Repository(getApplication());
        final ExamAdapter examAdapter = new ExamAdapter(this);
        recyclerView.setAdapter(examAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Exam> filteredExams = new ArrayList<>();
        for (Exam e : repository.getAllExams()) {
            if (e.getCourseID() == id) filteredExams.add(e);
        }
        examAdapter.setExams(filteredExams);

        Button bbutton = findViewById(R.id.backBtn);
        bbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Intent intent1 = new Intent(CourseDetails.this, CourseList.class);
                startActivity(intent1);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_det_course, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            case R.id.sendCourse:
                Course course;
                if (id == -1) {
                    if (repository.getAllCourses().size() == 0) id = 1;
                    else
                        id = repository.getAllCourses().get(repository.getAllCourses().size() - 1).getCourseID() + 1;
                    course = new Course(id, editName.getText().toString(), ecourseStart.getText().toString(), ecourseEnd.getText().toString(), ecourseNotes.getText().toString(), 1);
                    repository.insertCourse(course);
                    Intent intent1 = new Intent(CourseDetails.this, CourseList.class);
                    startActivity(intent1);

                } else {
                    course = new Course(id, editName.getText().toString(), ecourseStart.getText().toString(), ecourseEnd.getText().toString(), ecourseNotes.getText().toString(), 1);
                    repository.updateCourse(course);
                    Intent intent1 = new Intent(CourseDetails.this, CourseList.class);
                    startActivity(intent1);
                }

                return true;

            case R.id.delCourse:
                for (Course course2 : repository.getAllCourses()) {
                    if (course2.getCourseID() == id) currentCourse = course2;
                }

                numExams = 0;
                for (Exam exam : repository.getAllExams()) {
                    if (exam.getCourseID() == id) ++numExams;
                }

                if (numExams == 0) {
                    repository.deleteCourse(currentCourse);
                    Toast.makeText(CourseDetails.this, currentCourse.getCourseName() + " was deleted", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(CourseDetails.this, "Can't delete a course with exam(s)", Toast.LENGTH_LONG).show();
                }
                return true;
        }
        //Placeholder menu options
        //case R.id.remCourse:

        //case R.id.addCourse:


        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        RecyclerView recyclerView = findViewById(R.id.examRecView);
        final ExamAdapter examAdapter = new ExamAdapter(this);
        recyclerView.setAdapter(examAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Exam> filteredExams = new ArrayList<>();
        for (Exam e : repository.getAllExams()) {
            if (e.getExamID() == id) filteredExams.add(e);
        }
        examAdapter.setExams(filteredExams);

    }
}