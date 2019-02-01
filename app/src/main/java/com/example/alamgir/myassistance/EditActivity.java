package com.example.alamgir.myassistance;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {
    EditText etName, etEmail,etPhone;
    Button btnUpDate, btnDelete;
    StudentDatabase db;
    Student student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        etName=findViewById(R.id.editName);
        etEmail=findViewById(R.id.editEmail);
        etPhone=findViewById(R.id.editPhone);
        btnUpDate=findViewById(R.id.btnUpDate);
        btnDelete=findViewById(R.id.btnDelete);
        Intent intent=getIntent();
        student= (Student) intent.getSerializableExtra("student");
        db=Room.databaseBuilder(this,StudentDatabase.class,"student.db").allowMainThreadQueries().build();
        btnUpDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upDate();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
            }
        });
        etName.setText("Tanvir");
        etEmail.setText(student.getEmail());
        etPhone.setText(student.getPhone());
    }

    private void delete() {

        db.mDao().delete(student);
        startActivity(new Intent(EditActivity.this,MainActivity.class));
        finish();

    }
    private void upDate() {
        String name=etName.getText().toString();
        String email=etEmail.getText().toString();
        String phone=etPhone.getText().toString();
        Student student1=new Student(student.getId(),name,email,phone);
        db.mDao().update(student1);
        startActivity(new Intent(EditActivity.this,MainActivity.class));
        finish();
    }
}
