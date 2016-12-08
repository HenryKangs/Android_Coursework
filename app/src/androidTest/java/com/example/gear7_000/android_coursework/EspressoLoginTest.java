package com.example.gear7_000.android_coursework;

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

/**
 * Created by gear7_000 on 12/8/2016.
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class EspressoLoginTest {

    @Rule
    public ActivityTestRule<LoginActivity> activityTestRule1 = new ActivityTestRule<>(
            LoginActivity.class);

    @Test
    public void changeText_LoginActivity() {
        onView(withId(R.id.usernameText)).perform(typeText("Henry"), closeSoftKeyboard());
        onView(withId(R.id.passwordText)).perform(typeText("123"), closeSoftKeyboard());
        onView(withId(R.id.create_button)).perform(click());
    }
}
