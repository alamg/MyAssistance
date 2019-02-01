package com.example.alamgir.myassistance;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface StudentDao {
    @Insert
    public void insert(Student student);
    @Query("SELECT * FROM student_table")
    List<Student>getAllStudent();
    @Delete
    public void delete(Student student);
    @Update
    public void update(Student student);
}
