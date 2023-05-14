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
import com.example.c196_redo.Entities.Term;
import com.example.c196_redo.R;

import java.util.ArrayList;
import java.util.List;

public class TermDetails extends AppCompatActivity {
    Repository repository;
    EditText etermStart;
    EditText etermID;
    EditText etermEnd;
    EditText editName;
    EditText etermNotes;
    String notes;
    String start;
    String end;
    String name;
    int id;
    Term currentTerm;
    int numCourses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_details);

        name = getIntent().getStringExtra("name");
        editName = findViewById(R.id.termName);
        editName.setText(name);

        notes = getIntent().getStringExtra("notes");
        etermNotes = findViewById(R.id.termNotes);
        etermNotes.setText(notes);

        start = getIntent().getStringExtra("start");
        etermStart = findViewById(R.id.termStart);
        etermStart.setText(start);

        end = getIntent().getStringExtra("end");
        etermEnd = findViewById(R.id.termEnd);
        etermEnd.setText(end);

        id = getIntent().getIntExtra("id", -1);
        etermID = findViewById(R.id.termID);
        etermID.setText("Auto-Generated");

        RecyclerView recyclerView = findViewById(R.id.courseRecView);
        repository = new Repository(getApplication());
        final CourseAdapter courseAdapter = new CourseAdapter(this);
        recyclerView.setAdapter(courseAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Course> filteredCourses = new ArrayList<>();
        for (Course c : repository.getAllCourses()) {
            if (c.getCourseID() == id) filteredCourses.add(c);
        }
        courseAdapter.setCourses(filteredCourses);

        Button bbutton = findViewById(R.id.backBtn);
        bbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Intent intent1 = new Intent(TermDetails.this, TermList.class);
                startActivity(intent1);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_det_term, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            case R.id.sendTerm:
                if(editName.getText() != null) {
                    Term term;
                    if (id == -1) {
                        if (repository.getAllTerms().size() == 0) id = 1;
                        else
                            id = repository.getAllTerms().get(repository.getAllTerms().size() - 1).getTermID() + 1;
                        term = new Term(id, editName.getText().toString(), etermStart.getText().toString(), etermEnd.getText().toString(), etermNotes.getText().toString());
                        repository.insertTerm(term);
                        Intent intent1 = new Intent(TermDetails.this, TermList.class);
                        startActivity(intent1);

                    } else {
                        term = new Term(id, editName.getText().toString(), etermStart.getText().toString(), etermEnd.getText().toString(), etermNotes.getText().toString());
                        repository.updateTerm(term);
                        Intent intent1 = new Intent(TermDetails.this, TermList.class);
                        startActivity(intent1);
                    }

                    return true;
                }
                else {
                    Toast.makeText(TermDetails.this, "Please enter a term name.", Toast.LENGTH_LONG).show();
                }

            case R.id.delTerm:
                for (Term term2 : repository.getAllTerms()) {
                    if (term2.getTermID() == id) currentTerm = term2;
                }

                numCourses = 0;
                for (Course course : repository.getAllCourses()) {
                    if (course.getTermID() == id) ++numCourses;
                }

                if (numCourses == 0) {
                    repository.deleteTerm(currentTerm);
                    Toast.makeText(TermDetails.this, currentTerm.getTermName() + " was deleted", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(TermDetails.this, "Can't delete a Term with courses", Toast.LENGTH_LONG).show();
                }

                return true;

            case R.id.addCourse:
                Repository repo = new Repository(getApplication());
                Intent intent5 = new Intent(TermDetails.this, CourseDetails.class);
                startActivity(intent5);

                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        RecyclerView recyclerView = findViewById(R.id.courseRecView);
        final CourseAdapter courseAdapter = new CourseAdapter(this);
        recyclerView.setAdapter(courseAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Course> filteredCourses = new ArrayList<>();
        for (Course c : repository.getAllCourses()) {
            if (c.getCourseID() == id) filteredCourses.add(c);
        }
        courseAdapter.setCourses(filteredCourses);

    }
}