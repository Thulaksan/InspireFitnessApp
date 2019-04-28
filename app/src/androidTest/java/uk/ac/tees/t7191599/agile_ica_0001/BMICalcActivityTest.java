package uk.ac.tees.t7191599.agile_ica_0001;

import android.support.test.rule.ActivityTestRule;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.After;
import org.junit.Assert;
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
public class BMICalcActivityTest {
    @Rule
    public ActivityTestRule<BMICalcActivity> bmiCalcActivityActivityTestRule = new ActivityTestRule<BMICalcActivity>(BMICalcActivity.class);

    private BMICalcActivity bmiCalcActivity = null;


    @Before
    public void setUp() throws Exception {
        bmiCalcActivity = bmiCalcActivityActivityTestRule.getActivity();
    }

    @After
    public void tearDown() throws Exception {
        bmiCalcActivity = null;
    }

    @Test
    public void calc() throws Exception {
        EditText et_height = (EditText) bmiCalcActivity.findViewById(R.id.et_height);
        EditText et_weight = (EditText) bmiCalcActivity.findViewById(R.id.et_weight);
        TextView bmistat = bmiCalcActivity.findViewById(R.id.tv_BMI_Status);

        et_height.setText("5");
        et_weight.setText("1000");

        onView(withId(R.id.Calculate)).perform(click());

        Assert.assertEquals("obese", bmistat.getText());

    }



}