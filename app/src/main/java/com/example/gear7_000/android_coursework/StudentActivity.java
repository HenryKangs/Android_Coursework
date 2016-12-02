package com.example.gear7_000.android_coursework;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class StudentActivity extends AppCompatActivity {
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
        db = new DatabaseHandler(this);
        //db.addStudentInfo(new Student(129387, "Jordan", "Day", "123 Alma", "jordan@gmail.com", "074548829",""));
        //db.addStudentInfo(new Student(122998, "Henry", "Kang", "223 Saha", "henry@hotmail.com", "074548829",""));
        //db.addStudentInfo(new Student(204985, "Kyle", "Barnes", "334 Jood", "kyle@gmail.com", "074234429",""));
        //db.addStudentInfo(new Student(204756,"Jason","Day","243 Kings","jason@yahoo.com","074523419",""));
        //db.addStudentInfo(new Student(305784,"Femi","Dugan","23 Alma","femi@naver.com","074665139"));
        //db.addStudentInfo(new Student(309564,"Lee","Kim","102 Alma","kim@gmail.com","074534539"));
        //db.addStudentInfo(new Student(143387,"James","Kim","111 Alma","james@gmail.com","076548829"));
        //db.addStudentInfo(new Student(164998,"Sin","Lee","233 Saha","lee@hotmail.com","074523429"));
        //db.addStudentInfo(new Student(289985,"Jimmy","Kayne","343 Jood","jimmy@gmail.com","074234429"));
        //db.addStudentInfo(new Student(784756,"James","West","22 Kings","west@yahoo.com","074523419"));
        //db.addStudentInfo(new Student(955784,"Kim","Peter","223 Alma","peter@naver.com","074522139"));
        //db.addStudentInfo(new Student(289564,"Lyon","Penn","101 Alma","lyon@gmail.com","074589739"));
        //db.addStudentInfo(new Student(679387,"Lyan","Kyle","113 Alma","lyan@gmail.com","074523429"));
        //db.addStudentInfo(new Student(892918,"Bob","Jenny","234 Saha","bob@hotmail.com","074554329"));
        //db.addStudentInfo(new Student(244935,"Michael","Bisping","354 Jood","michael@gmail.com","023434429"));
        //db.addStudentInfo(new Student(564726,"Brown","Andreas","234 Kings","brown@yahoo.com","074556719"));
        //db.addStudentInfo(new Student(345764,"Ebube","Kami","265 Alma","ebube@naver.com","074522349"));
        //db.addStudentInfo(new Student(459564,"Yang","Ming","106 Alma","yang@gmail.com","074511239"));
        listView = (ListView) findViewById(R.id.listViewComplexStudent);
    }

    public void onReturnClick(View v) {
        finish();
    }

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
