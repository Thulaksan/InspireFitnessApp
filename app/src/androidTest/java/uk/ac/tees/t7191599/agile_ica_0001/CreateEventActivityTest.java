package uk.ac.tees.t7191599.agile_ica_0001;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.anything;
import static org.junit.Assert.*;

/**
 * Created by t7207089 on 28/04/19.
 */
public class CreateEventActivityTest {
    @Rule
    public ActivityTestRule<CreateEventActivity> createEventActivityActivityTestRule = new ActivityTestRule<CreateEventActivity>(CreateEventActivity.class);

    private CreateEventActivity createEventActivity = null;

    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(Gymactivity.class.getName(),null,false);
    Instrumentation.ActivityMonitor monitor1 = getInstrumentation().addMonitor(NutritionPlanner.class.getName(),null,false);
    Instrumentation.ActivityMonitor monitor2 = getInstrumentation().addMonitor(HealthTracker.class.getName(),null,false);


    @Before
    public void setUp() throws Exception {
        createEventActivity = createEventActivityActivityTestRule.getActivity();
    }

    @Test
    public void testGymActivityLaunch()
    {
        assertNotNull(createEventActivity.findViewById(R.id.Event_List));

        onData(anything()).inAdapterView(withId(R.id.Event_List)).atPosition(0).perform(click());

        Activity secondAct = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000);

        assertNotNull(secondAct);
    }

    @Test
    public void testNutritionPlannerLaunch()
    {
        assertNotNull(createEventActivity.findViewById(R.id.Event_List));

        onData(anything()).inAdapterView(withId(R.id.Event_List)).atPosition(1).perform(click());

        Activity secondAct = getInstrumentation().waitForMonitorWithTimeout(monitor1, 5000);

        assertNotNull(secondAct);
    }

    @Test
    public void testHealthTrackerLaunch()
    {
        assertNotNull(createEventActivity.findViewById(R.id.Event_List));

        onData(anything()).inAdapterView(withId(R.id.Event_List)).atPosition(2).perform(click());

        Activity secondAct = getInstrumentation().waitForMonitorWithTimeout(monitor2, 5000);

        assertNotNull(secondAct);
    }




    @After
    public void tearDown() throws Exception {
        createEventActivity = null;
    }



}