package com.example.gear7_000.android_coursework;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameText;
    private EditText passwordText;
    private DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new DatabaseHandler(this);
        usernameText = (EditText) findViewById(R.id.usernameText);
        passwordText = (EditText) findViewById(R.id.passwordText);
    }

    @Override
    protected void onResume() {
        super.onResume();
        usernameText.setText("");
        passwordText.setText("");
    }

    public void onRegisterClick(View v) {
        Intent intentDisplay = new Intent();
        intentDisplay.setAction("com.example.gear7_000.android_coursework.RegisterActivity");
        startActivity(intentDisplay);
    }

    public void onLoginClick(View v) {
        String username = usernameText.getText().toString();
        String password = passwordText.getText().toString();
        DatabaseHandler db = new DatabaseHandler(this);
        if (db.checkAccount(username, password)) {
            Intent intentDisplay = new Intent();
            intentDisplay.setAction("com.example.gear7_000.android_coursework.MainActivity");
            startActivity(intentDisplay);
        } else {
            Toast.makeText(getApplicationContext(), "Username or password is incorrect.", Toast.LENGTH_LONG).show();
        }
    }
}
