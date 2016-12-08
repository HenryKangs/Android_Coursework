package com.example.gear7_000.android_coursework;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SmallTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class EspressoRegisterTest {

    @Rule
    public ActivityTestRule<RegisterActivity> activityTestRule1 = new ActivityTestRule<>(
            RegisterActivity.class);

    @Test
    public void changeText_RegisterActivity() {
        onView(withId(R.id.usernameText)).perform(typeText("Yusuf"), closeSoftKeyboard());
        onView(withId(R.id.passwordText)).perform(typeText("123"), closeSoftKeyboard());
        onView(withId(R.id.passwordConfirmText)).perform(typeText("123"), closeSoftKeyboard());
        onView(withId(R.id.create_button)).perform(click());
    }

//    @Rule
//    public ActivityTestRule<StudentAddActivity> activityTestRule2 = new ActivityTestRule<>(
//            StudentAddActivity.class);

//    @Test
//    public void changeText_StudentActivity() {
//        onView(withId(R.id.camera_button)).perform(click());
//        onView(withId(R.id.idText)).perform(typeText("9987"), closeSoftKeyboard());
//        onView(withId(R.id.nameTextFirst)).perform(typeText("Bradley"), closeSoftKeyboard());
//        onView(withId(R.id.nameTextLast)).perform(typeText("Kim"), closeSoftKeyboard());
//        onView(withId(R.id.addressText)).perform(typeText("CQ67QA"), closeSoftKeyboard());
//        onView(withId(R.id.emailText)).perform(typeText("gear5511@gmail.com"), closeSoftKeyboard());
//        onView(withId(R.id.phoneText)).perform(typeText("07564738475"), closeSoftKeyboard());
//        onView(withId(R.id.create_button)).perform(click());
//    }
}
