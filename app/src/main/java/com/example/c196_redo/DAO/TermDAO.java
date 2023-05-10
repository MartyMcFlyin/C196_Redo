package com.example.c196_redo.DAO;

import static androidx.room.OnConflictStrategy.IGNORE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.c196_redo.Entities.Term;

import java.util.List;

@Dao
public interface TermDAO {
    @Insert(onConflict = IGNORE)
    void insertTerm(Term term);

    @Update(onConflict = IGNORE)
    void updateTerm(Term term);

    @Delete()
    void deleteTerm(Term term);

    @Query("SELECT * FROM termsTable ORDER BY termID ASC")
    List<Term> getAllTerms();

}
