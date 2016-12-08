package com.example.gear7_000.android_coursework;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.test.filters.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by gear7_000 on 12/7/2016.
 */
@SmallTest
@RunWith(MockitoJUnitRunner.class)
public class StudentTest {

    @Mock
    Context context;

    @Mock
    Activity activity;

    @Mock
    SharedPreferences sharedPreferences;

    @Mock
    SharedPreferences.Editor editor;

    private Student student;

    @Test
    public void testCalculate() throws Exception {
        Student localStudent = new Student(100,"Henry","kang","CV15QA","gear7711@hotmail.com","07464748275","filepath");
        assertEquals(localStudent.getEmail(), "gear7711@hotmail.com");
    }

    @Test
    public void testCalculate2() throws Exception {
        Student anotherStudent = new Student(101,"James","kim","CV16BQ","gear7799@hotmail.com","07464748211","filepath");
        assertThat("check if time interval is calculated properly", anotherStudent.getAddress(), is(equalTo("CV16BQ")));

    }

    @Before
    public void initTests() {
        student = new Student(101,"Kyle","barnes","QA11BQ","gear6666@hotmail.com","07412348211","filepath", activity);
    }
}
