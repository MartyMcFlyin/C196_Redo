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
import com.example.c196_redo.Entities.Exam;
import com.example.c196_redo.Entities.Term;
import com.example.c196_redo.R;

import java.util.List;
import java.util.UUID;

public class TermList extends AppCompatActivity {

    private Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_list);

        /**Need floating?
        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(TermList.this, TermDetails.class);
                startActivity(intent4);
            }
        });*/

        repository = new Repository(getApplication());
        List<Term> allTerms = repository.getAllTerms();
        RecyclerView recyclerView = findViewById(R.id.termRecView);
        final TermAdapter termAdapter = new TermAdapter(this);
        recyclerView.setAdapter(termAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        termAdapter.setTerms(allTerms);




        Button bbutton = findViewById(R.id.backBtn);
        bbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Intent intent1 = new Intent(TermList.this, MainActivity.class);
                startActivity(intent1);
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_a_term, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home:
                this.finish();
//                Intent intent=new Intent(TermDetails.this,MainActivity.class);
//                startActivity(intent);
                return true;

            case R.id.addTerm:
                Repository repo = new Repository(getApplication());

                //aDD A SET OF DATA TO THE DB
                String random = UUID.randomUUID().toString();
                Term term = new Term(0, random, "1/1/2024", "1/2/2024", "Yada Yada Yada");
                Course course = new Course(0, random, "2/1/2024", "2/2/2024", "Yuda Yuda Yuda", 1);
                Exam exam = new Exam(0, random, "3/1/2024", "3/2/2024", "Yoa Yoda Yoda");
                Repository repository = new Repository(getApplication());
                repository.insertTerm(term);
                repository.insertCourse(course);
                repository.insertExam(exam);

                List<Term> allTerms=repository.getAllTerms();
                RecyclerView recyclerView=findViewById(R.id.termRecView);
                final TermAdapter termAdapter=new TermAdapter(this);
                recyclerView.setAdapter(termAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                termAdapter.setTerms(allTerms);

                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        List<Term> allTerms = repository.getAllTerms();
        RecyclerView recyclerView = findViewById(R.id.termRecView);
        final TermAdapter termAdapter = new TermAdapter(this);
        recyclerView.setAdapter(termAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        termAdapter.setTerms(allTerms);

    }


}