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

@SmallTest
@RunWith(AndroidJUnit4.class)
public class InstrumentedBuildingTest {

    private Building building;

    @Before
    public void initTests() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        building = new Building("Library","It was built in 1980...",1, context);
    }

    @Test
    public void testCalculate() {
        Log.d("actual_results", building.getName());
        assertThat(building.getName(), Matchers.is(Matchers.equalTo("Library")));
    }
}
