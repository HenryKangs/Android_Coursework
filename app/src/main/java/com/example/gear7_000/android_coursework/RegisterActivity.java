package com.example.gear7_000.android_coursework;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    //edittexts which receive username, password and confirm password are declared.
    public EditText usernameText;
    public EditText passwordText;
    public EditText passwordConfirmText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //aforementioned edittexts are initialized with variables.
        usernameText = (EditText) findViewById(R.id.usernameText);
        passwordText = (EditText) findViewById(R.id.passwordText);
        passwordConfirmText = (EditText) findViewById(R.id.passwordConfirmText);
    }

    public void onCreateClick(View v) {
        //gets user input.
        String username = usernameText.getText().toString();
        String password = passwordText.getText().toString();
        String confirm = passwordConfirmText.getText().toString();
        //checks if username is not empty.
        if (!username.matches("")) {
            //checks if the first and second password inputs match.
            if (password.equals(confirm)) {
                DatabaseHandler db = new DatabaseHandler(this);
                //if the account that the user wishes to create is not already created.
                if (!db.addAccount(new Login(username, password))) {
                    Toast.makeText(getApplicationContext(), "Account successfully created.", Toast.LENGTH_LONG).show();
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Username already exists.", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "Passwords do not match.", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "Username required.", Toast.LENGTH_LONG).show();
        }
    }

    public void onReturnClick(View v) {
        finish();
    }
}
