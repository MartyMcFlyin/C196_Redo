package com.example.c196_redo.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "coursesTable")
public class Course {
    @PrimaryKey(autoGenerate = true)
    private int courseID;
    private String courseName;
    private String startDate;
    private String endDate;
    private String courseNotes;
    private int termID;
    private String courseStatus;
    private String courseInstructor;
    private String courseContact;

    public Course(int courseID, String courseName, String startDate, String endDate, String courseNotes, int termID, String courseStatus, String courseInstructor, String courseContact) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.courseNotes = courseNotes;
        this.termID = termID;
        this.courseInstructor = courseInstructor;
        this.courseContact = courseContact;
        this.courseStatus = courseStatus;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
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

    public String getCourseNotes() {
        return courseNotes;
    }

    public void setCourseNotes(String courseNotes) {
        this.courseNotes = courseNotes;
    }

    public int getTermID() {return termID;}

    public void setTermID(int productID) {this.termID = productID;}

    public String getCourseStatus() {
        return courseStatus;
    }

    public void setCourseStatus(String courseStatus) {
        this.courseStatus = courseStatus;
    }

    public String getCourseInstructor() {
        return courseInstructor;
    }

    public void setCourseInstructor(String courseInstructor) {
        this.courseInstructor = courseInstructor;
    }

    public String getCourseContact() {
        return courseContact;
    }

    public void setCourseContact(String courseContact) {
        this.courseContact = courseContact;
    }
}
