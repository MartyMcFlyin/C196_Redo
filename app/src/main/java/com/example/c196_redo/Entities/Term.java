package com.example.c196_redo.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "termsTable")
public class Term {

    @PrimaryKey(autoGenerate = true)
    private int termID;
    private String termName;
    private String startDate;
    private String endDate;
    private String termNotes;
    boolean startOn = false;
    boolean endOn = false;

    public Term(int termID, String termName, String startDate, String endDate, String termNotes, boolean startOn, boolean endOn) {
        this.termID = termID;
        this.termName = termName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.termNotes = termNotes;
        this.startOn = startOn;
        this.endOn = endOn;
    }

    public int getTermID() {
        return termID;
    }

    public void setTermID(int termID) {
        this.termID = termID;
    }

    public String getTermName() {
        return termName;
    }

    public void setTermName(String termName) {
        this.termName = termName;
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

    public String getTermNotes() {
        return termNotes;
    }

    public void setTermNotes(String termNotes) {
        this.termNotes = termNotes;
    }

    public boolean isStartOn() {return startOn;}

    public void setStartOn(boolean startOn) {this.startOn = startOn;}

    public boolean isEndOn() {return endOn;}

    public void setEndOn(boolean endOn) {this.endOn = endOn;}
}

