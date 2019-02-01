package com.example.alamgir.myassistance;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fab;
    int REQUEST_CODE=1;
    StudentViewModel mViewModel;
    StudentDatabase db;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    Button btndelete, btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fab=findViewById(R.id.fab);
        recyclerView=findViewById(R.id.mRecyclerView);
       // btndelete=findViewById(R.id.delete);
       // btnUpdate=findViewById(R.id.update);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,AddNewStudentActivity.class));
            }
        });
         db= Room.databaseBuilder(this,StudentDatabase.class,"student.db").allowMainThreadQueries().build();
        List<Student>allStudens=db.mDao().getAllStudent();
        StudentAdapter adapter=new StudentAdapter(MainActivity.this,allStudens);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        /*btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student=new Student();
                student.setId(1);
                db.mDao().delete(student);
            }
        });*/
        /*btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student=new Student();
                student.setId(1);
                student.setName("Tanim");
                db.mDao().update(student);
            }
        });*/


    }

}
