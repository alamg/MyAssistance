package com.example.alamgir.myassistance;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;

@Entity(tableName = "student_table")
public class Student implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    @ColumnInfo(name = "name")
    private  String Name;
    @ColumnInfo(name = "email")
    private  String Email;
    @ColumnInfo(name = "phone")
    private  String Phone;

    public Student() {
    }

    public Student(@NonNull int id, String name, String email, String phone) {
        this.id = id;
        Name = name;
        Email = email;
        Phone = phone;
    }

    public Student(String name, String email, String phone) {
        Name = name;
        Email = email;
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
