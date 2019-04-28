package uk.ac.tees.t7191599.agile_ica_0001;

import android.support.test.rule.ActivityTestRule;
import android.widget.EditText;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Created by t7207089 on 28/04/19.
 */
public class NutritionPlannerTest {
    @Rule
    public ActivityTestRule<NutritionPlanner> nutritionPlannerActivityTestRule = new ActivityTestRule<NutritionPlanner>(NutritionPlanner.class);

    private NutritionPlanner nutritionPlanner = null;

    @Before
    public void setUp() throws Exception {
        nutritionPlanner = nutritionPlannerActivityTestRule.getActivity();
    }


    @Test
    public void totalCalorie() throws Exception {

        Assert.assertEquals(0, nutritionPlanner.totalCalorie());

    }

    @Test
    public void addEvent() throws Exception {
        EditText foodName = (EditText) nutritionPlanner.findViewById(R.id.foodSearchBar);

        foodName.setText("pasta");

        onView(withId(R.id.searchButton)).perform(click());

        Assert.assertEquals(400, nutritionPlanner.totalCalorie());

    }



    @After
    public void tearDown() throws Exception {

        nutritionPlanner = null;

    }



}