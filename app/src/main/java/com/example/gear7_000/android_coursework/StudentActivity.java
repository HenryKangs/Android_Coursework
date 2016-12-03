package com.example.gear7_000.android_coursework;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class StudentActivity extends AppCompatActivity {
    //Various String keys are declared in order to pass student object data via intent method.
    private ListView listView;
    private DatabaseHandler db;
    public static final String INFO_ONE = "StudentID";
    public static final String INFO_TWO = "Firstname";
    public static final String INFO_THREE = "Lastname";
    public static final String INFO_FOUR = "Address";
    public static final String INFO_FIVE = "Email";
    public static final String INFO_SIX = "Phone";
    public static final String INFO_SEVEN = "ID";
    public static final String INFO_EIGHT = "Imagepaths";
    private ArrayList<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        //database is initialized.
        db = new DatabaseHandler(this);
        listView = (ListView) findViewById(R.id.listViewComplexStudent);
    }

    public void onReturnClick(View v) {
        finish();
    }

    //if add button is clicked, function that creates a student object is called.
    public void onAddClick(View v) {
        Intent intentStudentinfo = new Intent();
        intentStudentinfo.setAction("com.example.gear7_000.android_coursework.StudentAddActivity");
        Bundle bundle = new Bundle();
        intentStudentinfo.putExtras(bundle);
        startActivity(intentStudentinfo);
    }

    @Override
    protected void onResume() {
        super.onResume();
        studentList = new ArrayList<>();
        studentList = db.getAllstudents();

        listView.setAdapter(new StudentAdapter(this, R.layout.list_student_item, studentList));
        listView.setOnItemClickListener(
                //student objects are refreshed and displayed back to users.
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intentDisplay = new Intent();
                        Bundle bundle = new Bundle();
                        intentDisplay.setAction("com.example.gear7_000.android_coursework.StudentDisplayInfo");
                        intentDisplay.putExtra(INFO_ONE, String.valueOf(studentList.get(position).getId()));
                        intentDisplay.putExtra(INFO_TWO, studentList.get(position).getFirstname());
                        intentDisplay.putExtra(INFO_THREE, studentList.get(position).getLastname());
                        intentDisplay.putExtra(INFO_FOUR, studentList.get(position).getAddress());
                        intentDisplay.putExtra(INFO_FIVE, studentList.get(position).getEmail());
                        intentDisplay.putExtra(INFO_SIX, studentList.get(position).getPhone());
                        intentDisplay.putExtra(INFO_SEVEN, String.valueOf(studentList.get(position).getId()));
                        intentDisplay.putExtra(INFO_EIGHT, studentList.get(position).getImagepaths());
                        intentDisplay.putExtras(bundle);
                        startActivity(intentDisplay);
                    }
                }
        );
    }
}
