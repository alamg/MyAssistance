package com.example.alamgir.myassistance;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNewStudentActivity extends AppCompatActivity {
    EditText etName,etEmail,etPhone;
    Button btnSave;
    public  static  final String STUDENT_CODE="STUDENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_student);
        etName=findViewById(R.id.etName);
        etEmail=findViewById(R.id.etEmail);
        etPhone=findViewById(R.id.etPhone);
        btnSave=findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AddNewStudentActivity.this,MainActivity.class);
                if(TextUtils.isEmpty(etName.getText())){
                    setResult(RESULT_CANCELED,intent);
                }else {
                    String name=etName.getText().toString().trim();
                    String email=etEmail.getText().toString().trim();
                    String phone=etPhone.getText().toString().trim();
                    StudentDatabase db=Room.databaseBuilder(getApplicationContext(),
                            StudentDatabase.class,"student.db").allowMainThreadQueries().build();
                    Student student=new Student(name,email,phone);
                    db.mDao().insert(student);
                    Toast.makeText(getApplicationContext(),"Saved",Toast.LENGTH_LONG).show();
                    startActivity(intent);
                }

            }
        });
    }
}
