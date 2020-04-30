package com.example.cobanavfragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cobanavfragment.R;

import java.util.ArrayList;

public class CardView extends RecyclerView.Adapter<CardView.StudentViewHolder> {

    private Context context;
    private ArrayList<Student> listStudent = new ArrayList<>();

    public CardView(Context context) {
        this.context = context;
    }

    public void setListStudent(ArrayList<Student> listStudent){
        this.listStudent.clear();
        this.listStudent.addAll(listStudent);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_student, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = listStudent.get(position);
        holder.id.setText(student.getId());
        holder.name.setText(student.getName());
        holder.email.setText(student.getEmail());
    }

    @Override
    public int getItemCount() {
        return listStudent.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder{
        TextView id, name, email;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.student_id);
            name = itemView.findViewById(R.id.student_name);
            email = itemView.findViewById(R.id.student_email);
        }
    }
}
