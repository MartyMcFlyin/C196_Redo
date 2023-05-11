package com.example.c196_redo.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "examsTable")
public class Exam {
    @PrimaryKey(autoGenerate = true)
    private int examID;
    private String examName;
    private String startDate;
    private String endDate;
    private String examNotes;
    private int courseID;

    public Exam(int examID, String examName, String startDate, String endDate, String examNotes, int courseID) {
        this.examID = examID;
        this.examName = examName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.examNotes = examNotes;
        this.courseID = courseID;
    }

    public int getExamID() {
        return examID;
    }

    public void setExamID(int examID) {
        this.examID = examID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getExamNotes() {
        return examNotes;
    }

    public void setExamNotes(String examNotes) {
        this.examNotes = examNotes;
    }
}
