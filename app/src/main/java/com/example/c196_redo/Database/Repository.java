package com.example.c196_redo.Database;

import android.app.Application;

import com.example.c196_redo.DAO.CourseDAO;
import com.example.c196_redo.DAO.ExamDAO;
import com.example.c196_redo.DAO.TermDAO;
import com.example.c196_redo.Entities.Course;
import com.example.c196_redo.Entities.Exam;
import com.example.c196_redo.Entities.Term;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {
    private CourseDAO mcourseDAO;
    private ExamDAO mexamDAO;
    private TermDAO mtermDAO;

    //Testing Git Commit
    private int i = 0;

    private List<Term> mAllTerms;
    private List<Course> mAllCourses;
    private List<Exam> mAllExams;

    private static int NUMBER_OF_THREADS = 4;

    static final ExecutorService databaseExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public Repository(Application application) {
        SchedulerDatabase db = SchedulerDatabase.getDatabase(application);
        mtermDAO = db.termDAO();
        mcourseDAO = db.courseDAO();
        mexamDAO = db.examDAO();
    }

    public List<Term> getAllTerms() {
        databaseExecutor.execute(() -> {
            mAllTerms = mtermDAO.getAllTerms();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return mAllTerms;
    }

    public List<Course> getAllCourses() {
        databaseExecutor.execute(() -> {
            mAllCourses = mcourseDAO.getAllCourses();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return mAllCourses;
    }

    public List<Exam> getAllExams() {
        databaseExecutor.execute(() -> {
            mAllExams = mexamDAO.getAllExams();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return mAllExams;
    }

    public void insertTerm(Term term) {
        databaseExecutor.execute(()->{
            mtermDAO.insertTerm(term);
        });
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void updateTerm(Term term) {
        databaseExecutor.execute(()->{
            mtermDAO.updateTerm(term);

        });
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        };
    }

    public void deleteTerm(Term term) {
        databaseExecutor.execute(()->{
            mtermDAO.deleteTerm(term);
        });
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void insertCourse(Course course) {
        databaseExecutor.execute(()->{
            mcourseDAO.insertCourse(course);
        });
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void updateCourse(Course course) {
        databaseExecutor.execute(()->{
            mcourseDAO.updateCourse(course);

        });
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        };
    }

    public void deleteCourse(Course course) {
        databaseExecutor.execute(()->{
            mcourseDAO.deleteCourse(course);
        });
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void insertExam(Exam exam) {
        databaseExecutor.execute(()->{
            mexamDAO.insertExam(exam);
        });
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void updateExam(Exam exam) {
        databaseExecutor.execute(()->{
            mexamDAO.updateExam(exam);

        });
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        };
    }

    public void deleteExam(Exam exam) {
        databaseExecutor.execute(()->{
            mexamDAO.deleteExam(exam);
        });
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}