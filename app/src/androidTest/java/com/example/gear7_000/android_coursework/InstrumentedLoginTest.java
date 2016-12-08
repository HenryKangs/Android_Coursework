package com.example.gear7_000.android_coursework;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class InstrumentedLoginTest {

    private Login login;

    @Before
    public void initTests() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        login = new Login("David","123", context);
    }

    @Test
    public void testCalculate() {
        Log.d("actual_results", login.getUsername());
        assertThat(login.getUsername(), is(equalTo("David")));
    }

}
