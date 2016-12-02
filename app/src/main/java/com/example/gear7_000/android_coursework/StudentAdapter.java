package com.example.gear7_000.android_coursework;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends ArrayAdapter<Student> {

    private int resource;
    private ArrayList<Student> students;
    private Context context;

    public StudentAdapter(Context context, int resource, ArrayList<Student> students) {
        super(context, resource, students);
        this.resource = resource;
        this.students = students;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        try {
            if (v == null) {
                LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = layoutInflater.inflate(resource, parent, false);
            }

            TextView textViewName = (TextView) v.findViewById(R.id.textViewName);

            textViewName.setText(students.get(position).getFirstname() + " " + students.get(position).getLastname());

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return v;
    }
}