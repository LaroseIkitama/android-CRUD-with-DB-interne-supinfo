package com.example.ikitama_larose_crud_db_interne;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class StudentAdapter extends ArrayAdapter<Student> {
    public StudentAdapter(Context context, Student[] students){
        super(context,0,students);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Student student=getItem(position);

        if (convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.student_list_item,parent,false);
        }

        TextView tvName=convertView.findViewById(R.id.tvName);
        TextView tvFirstname=convertView.findViewById(R.id.tvFirstname);
        TextView tvClassroom=convertView.findViewById(R.id.tvClassroom);
        TextView tvYear=convertView.findViewById(R.id.tvYear);

        tvName.setText(student.getName());
        tvFirstname.setText(student.getFirstname());
        tvClassroom.setText(student.getClassroom());
        tvYear.setText(student.getYear());

        return convertView;
    }
}
