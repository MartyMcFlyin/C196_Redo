package com.example.c196_redo.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.c196_redo.Database.Repository;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.c196_redo.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

public class TermDetails extends AppCompatActivity {
    Repository repository;
    EditText etermStart;
    EditText etermID;
    EditText etermEnd;
    EditText etermName;
    EditText etermNotes;
    private String notes;
    private String start;
    private String end;
    private String name;
    private int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_details);

        etermStart = findViewById(R.id.termStart);
        etermEnd = findViewById(R.id.termEnd);
        etermName = findViewById(R.id.termName);
        etermNotes = findViewById(R.id.termNotes);
        etermID = findViewById(R.id.termID);
        name = getIntent().getStringExtra(name);
        notes = getIntent().getStringExtra(notes);
        start = getIntent().getStringExtra(start);
        end = getIntent().getStringExtra(end);
        etermStart.setText(start);
        etermEnd.setText(end);
        etermNotes.setText(notes);
        etermName.setText(name);
        etermID.setText("Placeholder");

        Button bbutton = findViewById(R.id.backBtn);
        bbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Intent intent1 = new Intent(TermDetails.this, TermList.class);
                startActivity(intent1);
            }
        });
      /**  RecyclerView recyclerView = findViewById(R.id.courseRecView);
        repository = new Repository(getApplication());
        final TermAdapter termAdapter = new TermAdapter(this);
        recyclerView.setAdapter(termAdapter);
        List<Course> filteredCourses = new ArrayList<>();
        for (Course c : repository.getAllCourses()) {
            if (c.getTermID() == termID) filteredTerms.add(p);
        }
        termAdapter.setTerms(filteredTerms);

        FloatingActionButton fab = findViewById(R.id.floatingActionButton2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TermDetails.this, CourseDetails.class);
                intent.putExtra("termID", termID);
                startActivity(intent);
            }
        }); */
    }

}