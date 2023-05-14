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

import com.example.c196_redo.Database.Repository;
import com.example.c196_redo.Entities.Exam;
import com.example.c196_redo.R;

public class ExamDetails extends AppCompatActivity {

    Repository repository;
    EditText eexamStart;
    EditText eexamID;
    EditText eexamEnd;
    EditText editName;
    EditText eexamNotes;
    String notes;
    String start;
    String end;
    String name;
    int id;
    Exam currentExam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_details);

        name = getIntent().getStringExtra("name");
        editName = findViewById(R.id.examName);
        editName.setText(name);

        notes = getIntent().getStringExtra("notes");
        eexamNotes = findViewById(R.id.examNotes);
        eexamNotes.setText(notes);

        start = getIntent().getStringExtra("start");
        eexamStart = findViewById(R.id.examStart);
        eexamStart.setText(start);

        end = getIntent().getStringExtra("end");
        eexamEnd = findViewById(R.id.examEnd);
        eexamEnd.setText(end);

        id = getIntent().getIntExtra("id", -1);
        eexamID = findViewById(R.id.examID);
        eexamID.setText(String.valueOf(id));

        repository = new Repository(getApplication());


        Button bbutton = findViewById(R.id.backBtn);
        bbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Intent intent1 = new Intent(ExamDetails.this, ExamList.class);
                startActivity(intent1);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_det_exam, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            case R.id.sendExam:
                Exam exam;
                if (id == -1) {
                    if (repository.getAllExams().size() == 0) id = 1;
                    else
                        id = repository.getAllExams().get(repository.getAllExams().size() - 1).getExamID() + 1;
                    exam = new Exam(id, editName.getText().toString(), eexamStart.getText().toString(), eexamEnd.getText().toString(), eexamNotes.getText().toString(), 1);
                    repository.insertExam(exam);
                    Intent intent1 = new Intent(ExamDetails.this, ExamList.class);
                    startActivity(intent1);

                } else {
                    exam = new Exam(id, editName.getText().toString(), eexamStart.getText().toString(), eexamEnd.getText().toString(), eexamNotes.getText().toString(), 1);
                    repository.updateExam(exam);
                    Intent intent1 = new Intent(ExamDetails.this, ExamList.class);
                    startActivity(intent1);
                }

                return true;

            case R.id.delExam:

                    repository.deleteExam(currentExam);
                    Toast.makeText(ExamDetails.this, currentExam.getExamName() + " was deleted", Toast.LENGTH_LONG).show();

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

    }
}