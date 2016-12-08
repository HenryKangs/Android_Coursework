package com.example.gear7_000.android_coursework;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class StudentDisplayInfo extends AppCompatActivity {
    /**
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */
    private static final boolean AUTO_HIDE = true;
    private DatabaseHandler db;
    private TextView textView;
    ImageView mImageView;

    public static String DATA_ONE = "StudentID";
    public static String DATA_TWO = "Firstname";
    public static String DATA_THREE = "Secondname";
    public static String DATA_FOUR = "Address";
    public static String DATA_FIVE = "Email";
    public static String DATA_SIX = "Phone";
    public static String DATA_SEVEN = "Imagepaths";

    private String id;
    private String firstname;
    private String lastname;
    private String address;
    private String email;
    private String phone;
    private String imagepaths;
    /**
     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

    /**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */
    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler();
    private View mContentView;
    private final Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {
            // Delayed removal of status and navigation bar

            // Note that some of these constants are new as of API 16 (Jelly Bean)
            // and API 19 (KitKat). It is safe to use them, as they are inlined
            // at compile-time and do nothing on earlier devices.
            mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    };
    private View mControlsView;
    private final Runnable mShowPart2Runnable = new Runnable() {
        @Override
        public void run() {
            // Delayed display of UI elements
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.show();
            }
            mControlsView.setVisibility(View.VISIBLE);
        }
    };
    private boolean mVisible;
    private final Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            hide();
        }
    };
    /**
     * Touch listener to use for in-layout UI controls to delay hiding the
     * system UI. This is to prevent the jarring behavior of controls going away
     * while interacting with activity UI.
     */
    private final View.OnTouchListener mDelayHideTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (AUTO_HIDE) {
                delayedHide(AUTO_HIDE_DELAY_MILLIS);
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_display_info);
        mVisible = true;
        mControlsView = findViewById(R.id.fullscreen_content_controls);
        mContentView = findViewById(R.id.fullscreen_content);
        mImageView = (ImageView) findViewById(R.id.image);

        // Set up the user interaction to manually show or hide the system UI.
        mContentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggle();
            }
        });

        // Upon interacting with UI controls, delay any scheduled hide()
        // operations to prevent the jarring behavior of controls going away
        // while interacting with the UI.
        findViewById(R.id.return_button).setOnTouchListener(mDelayHideTouchListener);
        textView = (TextView) findViewById(R.id.fullscreen_content);
        StringBuilder messageFromActivity1 = new StringBuilder();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        messageFromActivity1.append("Student Information:\n\nStudent ID: " + intent.getStringExtra(StudentActivity.INFO_ONE) + System.getProperty("line.separator"));
        messageFromActivity1.append("First Name: " + intent.getStringExtra(StudentActivity.INFO_TWO) + System.getProperty("line.separator"));
        messageFromActivity1.append("Last Name: " + intent.getStringExtra(StudentActivity.INFO_THREE) + System.getProperty("line.separator"));
        messageFromActivity1.append("Address: " + intent.getStringExtra(StudentActivity.INFO_FOUR) + System.getProperty("line.separator"));
        messageFromActivity1.append("Email: " + intent.getStringExtra(StudentActivity.INFO_FIVE) + System.getProperty("line.separator"));
        messageFromActivity1.append("Phone: " + intent.getStringExtra(StudentActivity.INFO_SIX) + System.getProperty("line.separator"));

        id = intent.getStringExtra(StudentActivity.INFO_ONE);
        firstname = intent.getStringExtra(StudentActivity.INFO_TWO);
        lastname = intent.getStringExtra(StudentActivity.INFO_THREE);
        address = intent.getStringExtra(StudentActivity.INFO_FOUR);
        email = intent.getStringExtra(StudentActivity.INFO_FIVE);
        phone = intent.getStringExtra(StudentActivity.INFO_SIX);
        imagepaths = intent.getStringExtra(StudentActivity.INFO_EIGHT);
        setPic();
        textView.setText(messageFromActivity1);
    }

    protected void onResume() {
        super.onResume();
        db = new DatabaseHandler(this);
        Student student = db.getStudent(Integer.parseInt(id));
        StringBuilder messageFromActivity1 = new StringBuilder();
        messageFromActivity1.append("Student ID: " + student.getId() + System.getProperty("line.separator"));
        messageFromActivity1.append("First Name: " + student.getFirstname() + System.getProperty("line.separator"));
        messageFromActivity1.append("Last Name: " + student.getLastname() + System.getProperty("line.separator"));
        messageFromActivity1.append("Address: " + student.getAddress() + System.getProperty("line.separator"));
        messageFromActivity1.append("Email: " + student.getEmail() + System.getProperty("line.separator"));
        messageFromActivity1.append("Phone: " + student.getPhone() + System.getProperty("line.separator"));
        id = String.valueOf(student.getId());
        firstname = student.getFirstname();
        lastname = student.getLastname();
        address = student.getAddress();
        email = student.getEmail();
        phone = student.getPhone();
        imagepaths = student.getImagepaths();
        setPic();
        textView.setText(messageFromActivity1);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
        delayedHide(100);
    }

    private void toggle() {
        if (mVisible) {
            hide();
        } else {
            show();
        }
    }

    private void setPic() {
        File f = new File(imagepaths);
        if (f.exists()) {
            mImageView.setImageURI(Uri.fromFile(f));
        }
    }

    private void hide() {
        // Hide UI first
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        mControlsView.setVisibility(View.GONE);
        mVisible = false;

        // Schedule a runnable to remove the status and navigation bar after a delay
        mHideHandler.removeCallbacks(mShowPart2Runnable);
        mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY);
    }

    @SuppressLint("InlinedApi")
    private void show() {
        // Show the system bar
        mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        mVisible = true;

        // Schedule a runnable to display UI elements after a delay
        mHideHandler.removeCallbacks(mHidePart2Runnable);
        mHideHandler.postDelayed(mShowPart2Runnable, UI_ANIMATION_DELAY);
    }

    /**
     * Schedules a call to hide() in [delay] milliseconds, canceling any
     * previously scheduled calls.
     */
    private void delayedHide(int delayMillis) {
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, delayMillis);
    }

    public void onReturnClick(View v) {
        finish();
    }

    public void onDeleteClick(View v) {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        DatabaseHandler db = new DatabaseHandler(this);
        db.deleteStudentInfo(Integer.parseInt(intent.getStringExtra(StudentActivity.INFO_SEVEN)));
        finish();
    }

    public void onUpdateClick(View v) {
        Intent intentDisplay = new Intent();
        Bundle bundle = new Bundle();
        intentDisplay.setAction("com.example.gear7_000.android_coursework.StudentUpdateActivity");
        intentDisplay.putExtra(DATA_ONE, id);
        intentDisplay.putExtra(DATA_TWO, firstname);
        intentDisplay.putExtra(DATA_THREE, lastname);
        intentDisplay.putExtra(DATA_FOUR, address);
        intentDisplay.putExtra(DATA_FIVE, email);
        intentDisplay.putExtra(DATA_SIX, phone);
        intentDisplay.putExtra(DATA_SEVEN, imagepaths);
        intentDisplay.putExtras(bundle);
        startActivity(intentDisplay);
    }
}