package com.example.gear7_000.android_coursework;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentAddActivity extends AppCompatActivity {
    private EditText idText;
    private EditText nameTextFirst;
    private EditText nameTextLast;
    private EditText addressText;
    private EditText emailText;
    private EditText phoneText;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    String mCurrentPhotoPath;
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_add);
        mImageView = (ImageView) findViewById(R.id.image);
        idText = (EditText) findViewById(R.id.idText);
        nameTextFirst = (EditText) findViewById(R.id.nameTextFirst);
        nameTextLast = (EditText) findViewById(R.id.nameTextLast);
        addressText = (EditText) findViewById(R.id.addressText);
        emailText = (EditText) findViewById(R.id.emailText);
        phoneText = (EditText) findViewById(R.id.phoneText);
    }

    public void onAddClick(View v) {
        try {
            int id = Integer.parseInt(idText.getText().toString());
            String first_name = nameTextFirst.getText().toString();
            String last_name = nameTextLast.getText().toString();
            String address = addressText.getText().toString();
            String email = emailText.getText().toString();
            String phone = phoneText.getText().toString();
            String imagepaths = mCurrentPhotoPath;
            if (imagepaths != null) {
                DatabaseHandler db = new DatabaseHandler(this);
                if (db.addStudentInfo(new Student(id, first_name, last_name, address, email, phone, imagepaths))) {
                    Toast.makeText(getApplicationContext(), "Student successfully inserted.", Toast.LENGTH_LONG).show();
                    finish();
                } else if (false) {
                    Toast.makeText(getApplicationContext(), "Student already exists.", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "Photo required.", Toast.LENGTH_LONG).show();
            }
        } catch (NumberFormatException ex) {
            Toast.makeText(getApplicationContext(), "Student ID required.", Toast.LENGTH_LONG).show();
        }
    }

    public void onReturnClick(View v) {
        finish();
    }

    public void onCameraClick(View v) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.example.gear7_000.android_coursework.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, 111);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mImageView.setImageBitmap(imageBitmap);
        }
    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }
}
