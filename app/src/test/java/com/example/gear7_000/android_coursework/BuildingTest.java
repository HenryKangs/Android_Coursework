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
public class BuildingTest {

    @Mock
    Context context;

    @Mock
    Activity activity;

    @Mock
    SharedPreferences sharedPreferences;

    @Mock
    SharedPreferences.Editor editor;

    private Building building;

    @Test
    public void testCalculate() throws Exception {
        Building localBuilding = new Building("EC_Building","It was built in 1994...",1);
        assertEquals(localBuilding.getName(), "EC_Building");
    }

    @Test
    public void testCalculate2() throws Exception {
        Building anotherBuilding = new Building("Hub","It was built in 2000...",2);
        assertThat("check if time interval is calculated properly", anotherBuilding.getDetail(), is(equalTo("It was built in 2000...")));

    }

    @Before
    public void initTests() {
        building = new Building("George Eliot","It was built in 1999...",3, activity);
    }
}
