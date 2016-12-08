package com.example.gear7_000.android_coursework;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class InstrumentedStudentTest {

    private Student student;

    @Before
    public void initTests() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        student = new Student(100,"Henry","kang","CV15QA","gear7711@hotmail.com","07464748275","filepath");
    }

    @Test
    public void testCalculate() {
        Log.d("actual_results", student.getFirstname());
        assertThat(student.getFirstname(), Matchers.is(Matchers.equalTo("Henry")));
    }
}
