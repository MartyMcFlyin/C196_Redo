package com.example.c196_redo.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.c196_redo.DAO.CourseDAO;
import com.example.c196_redo.DAO.ExamDAO;
import com.example.c196_redo.DAO.TermDAO;
import com.example.c196_redo.Entities.Course;
import com.example.c196_redo.Entities.Exam;
import com.example.c196_redo.Entities.Term;

//Ver control for DB resets
@Database(entities = {Course.class, Exam.class, Term.class}, version = 9, exportSchema = false)
public abstract class SchedulerDatabase extends RoomDatabase {

    public abstract CourseDAO courseDAO();

    public abstract TermDAO termDAO();

    public abstract ExamDAO examDAO();

    public static volatile SchedulerDatabase INSTANCE;

    static SchedulerDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (SchedulerDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), SchedulerDatabase.class, "schedDB")
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build();
                } else
                    return INSTANCE;
            }

        }
        return INSTANCE;
    }

}

