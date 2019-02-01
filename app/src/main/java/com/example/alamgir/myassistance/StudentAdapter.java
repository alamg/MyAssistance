package com.example.alamgir.myassistance;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyViewHolder> {
    List<Student>studentList;
    LayoutInflater inflater;
    Context context;
    public StudentAdapter(Context context, List<Student>students) {
        studentList=students;
        this.context=context;
       inflater=LayoutInflater.from(context) ;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v=inflater.inflate(R.layout.item_layout,viewGroup,false);
        return new MyViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        final Student student=studentList.get(i);
        myViewHolder.tvName.setText(String.valueOf(student.getName()));
        myViewHolder.tvEmail.setText(String.valueOf(student.getEmail()));
        myViewHolder.tvPhone.setText(String.valueOf(student.getPhone()));
        myViewHolder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context.getApplicationContext(),EditActivity.class);
                intent.putExtra("student",student);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if ((studentList!=null)){
            return studentList.size();
        }else {
            return 0;
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvName,tvEmail,tvPhone;
        ImageView image;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.Show_name);
            tvEmail=itemView.findViewById(R.id.Show_email);
            tvPhone=itemView.findViewById(R.id.Show_phone);
            image=itemView.findViewById(R.id.ClickImage);
        }
    }
}
