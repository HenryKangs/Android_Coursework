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
import static org.mockito.Mockito.when;

/**
 * Created by gear7_000 on 12/7/2016.
 */
@SmallTest
@RunWith(MockitoJUnitRunner.class)
public class LoginTest {

    @Mock
    Context context;

    @Mock
    Activity activity;

    @Mock
    SharedPreferences sharedPreferences;

    @Mock
    SharedPreferences.Editor editor;

    private Login login;

    @Test
    public void testCalculate() throws Exception {
        Login localLogin = new Login("Henrykang","123");
        assertEquals(localLogin.getUsername(), "Henrykang");
    }

    @Test
    public void testCalculate2() throws Exception {
        Login anotherLogin = new Login("Henrykim","321");
        assertThat("check if time interval is calculated properly", anotherLogin.getUsername(), is(equalTo("Henrykim")));

    }

    @Before
    public void initTests() {
        login = new Login("George","123", activity);
    }
}
