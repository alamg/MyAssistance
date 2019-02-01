package com.example.alamgir.myassistance;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

public class StudentViewModel extends AndroidViewModel {
    private StudentDao sDao;
    public StudentDatabase sDatabase;
    public Context context;

    public StudentViewModel(@NonNull Application application) {
        super(application);
       // sDatabase=StudentDatabase.getDatabase(application);
        //sDao=sDatabase.mDao();

    }
    public  void insert(Student student){
        new InserAsyncTask(sDao).execute(student);
    }
    @Override
    protected void onCleared() {
        super.onCleared();
    }
    private class InserAsyncTask  extends AsyncTask<Student,Void,Void> {
        StudentDao mDao;
        public InserAsyncTask(StudentDao sDao) {
            mDao=sDao;
        }

        @Override
        protected Void doInBackground(Student... students) {
            mDao.insert(students[0]);
            return null;
        }
    }
}
