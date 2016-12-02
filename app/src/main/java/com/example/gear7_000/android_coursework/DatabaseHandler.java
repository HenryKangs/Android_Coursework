package com.example.gear7_000.android_coursework;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by gear7_000 on 11/8/2016.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE loginTable (Username,Password)");
        db.execSQL("CREATE TABLE studentTable (Student_ID,First_Name,Last_Name,Address,Email,Phone,Imagepaths)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public DatabaseHandler(Context context) {
        super(context, "testDB", null, 2);
    }

    public boolean addAccount(Login account) {
        ArrayList<Login> temp = new ArrayList<>();
        boolean status = false;
        temp = getAllaccounts();
        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i).getUsername().equals(account.getUsername())) {
                status = true;
            }
        }
        if (!status) {
            SQLiteDatabase db = this.getReadableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("Username", account.getUsername());
            contentValues.put("Password", account.getPassword());

            long result = db.insert("loginTable", null, contentValues);

            if (result > 0) {
                Log.d("dbhelper", "created successfully");
            } else {
                Log.d("dbhelper", "failed to create");
            }
            db.close();
        }
        return status;
    }

    public boolean checkAccount(String username, String password) {
        ArrayList<Login> temp = new ArrayList<>();
        boolean status = false;
        temp = getAllaccounts();
        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i).getUsername().equals(username) && temp.get(i).getPassword().equals(password)) {
                status = true;
            }
        }
        return status;
    }

    public ArrayList<Login> getAllaccounts() {
        ArrayList<Login> accounts = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM loginTable", null);

        if (c.moveToFirst()) {
            do {
                Login account = new Login();
                account.setUsername(c.getString(0));
                account.setPassword(c.getString(1));
                accounts.add(account);
            } while (c.moveToNext());
        }
        return accounts;
    }

    public boolean addStudentInfo(Student student) {
        ArrayList<Student> temp = new ArrayList<>();
        boolean status = false;
        temp = getAllstudents();
        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i).getId() == student.getId()) {
                status = true;
            }
        }
        if (!status) {
            SQLiteDatabase db = this.getReadableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("Student_ID", student.getId());
            contentValues.put("First_Name", student.getFirstname());
            contentValues.put("Last_Name", student.getLastname());
            contentValues.put("Address", student.getAddress());
            contentValues.put("Email", student.getEmail());
            contentValues.put("Phone", student.getPhone());
            contentValues.put("Imagepaths", student.getImagepaths());

            long result = db.insert("studentTable", null, contentValues);

            if (result > 0) {
                Log.d("dbhelper", "inserted successfully");
            } else {
                Log.d("dbhelper", "failed to insert");
            }
            db.close();
        } else {
            Log.d("dbhelper", "duplicate student id");
        }
        return status;
    }

    public void updateStudentInfo(Student student) {
        ArrayList<Student> temp = new ArrayList<>();
        boolean status = false;
        temp = getAllstudents();
        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i).getId() == student.getId()) {
                status = true;
            }
        }
        if (status) {
            SQLiteDatabase db = this.getReadableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("First_Name", student.getFirstname());
            contentValues.put("Last_Name", student.getLastname());
            contentValues.put("Address", student.getAddress());
            contentValues.put("Email", student.getEmail());
            contentValues.put("Phone", student.getPhone());
            contentValues.put("Imagepaths", student.getImagepaths());

            long result = db.update("studentTable", contentValues, "Student_ID = " + student.getId(), null);

            if (result > 0) {
                Log.d("dbhelper", "inserted successfully");
            } else {
                Log.d("dbhelper", "failed to insert");
            }
            db.close();
        } else {
            Log.d("dbhelper", "duplicate student id");
        }
    }

    public void deleteStudentInfo(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        long result = db.delete("studentTable", "Student_ID = " + id, null);

        if (result > 0) {
            Log.d("dbhelper", "deleted successfully");
        } else {
            Log.d("dbhelper", "failed to delete");
        }
        db.close();
    }

    public ArrayList<Student> getAllstudents() {
        ArrayList<Student> students = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM studentTable", null);

        if (c.moveToFirst()) {
            do {
                Student student = new Student();
                student.setId(Integer.parseInt(c.getString(0)));
                student.setFirstname(c.getString(1));
                student.setLastname(c.getString(2));
                student.setAddress(c.getString(3));
                student.setEmail(c.getString(4));
                student.setPhone(c.getString(5));
                student.setImagepaths(c.getString(6));
                students.add(student);
            } while (c.moveToNext());
        }
        return students;
    }

    public Student getStudent(int id) {
        Student student = new Student();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM studentTable WHERE STUDENT_ID = " + id, null);

        if (c.moveToFirst()) {
            do {
                student.setId(Integer.parseInt(c.getString(0)));
                student.setFirstname(c.getString(1));
                student.setLastname(c.getString(2));
                student.setAddress(c.getString(3));
                student.setEmail(c.getString(4));
                student.setPhone(c.getString(5));
                student.setImagepaths(c.getString(6));
            } while (c.moveToNext());
        }
        return student;
    }
}