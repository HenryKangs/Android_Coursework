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

    //variables needed to display student object is declared.
    private int resource;
    private ArrayList<Student> students;
    private Context context;

    //constructor receives list of student objects, context and resources as parameter.
    public StudentAdapter(Context context, int resource, ArrayList<Student> students) {
        super(context, resource, students);
        this.resource = resource;
        this.students = students;
        this.context = context;
    }

    @NonNull
    @Override
    //each student object's position, convertView and its parent are received as parameters.
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        try {
            if (v == null) {
                //takes a layout XML and parses it to create the view and viewgroup objects. In this case, list_student_item.xml
                LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = layoutInflater.inflate(resource, parent, false);
            }

            //recognizes one particular component which is textViewName.
            TextView textViewName = (TextView) v.findViewById(R.id.textViewName);
            //sets the component with the attribute of each student object.
            textViewName.setText(students.get(position).getFirstname() + " " + students.get(position).getLastname());

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return v;
    }
}