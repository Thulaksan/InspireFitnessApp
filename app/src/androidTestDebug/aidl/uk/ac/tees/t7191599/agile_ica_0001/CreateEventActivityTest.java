package uk.ac.tees.t7191599.agile_ica_0001;

import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static org.junit.Assert.*;

/**
 * Created by t7207089 on 04/04/19.
 */
public class CreateEventActivityTest {
    @Rule
    public ActivityTestRule<CreateEventActivity> createEventActivityActivityTestRule = new ActivityTestRule<CreateEventActivity>(CreateEventActivity.class);

    private CreateEventActivity createEventActivity= null;



    @Before
    public void setUp() throws Exception {
        createEventActivity = createEventActivityActivityTestRule.getActivity();
    }

    @Test
    public void testNutritionPlannerlaunch()
    {
        assertNotNull(createEventActivity.findViewById(R.id.Event_List));

        

    }


    @After
    public void tearDown() throws Exception {
        createEventActivity = null;
    }

}