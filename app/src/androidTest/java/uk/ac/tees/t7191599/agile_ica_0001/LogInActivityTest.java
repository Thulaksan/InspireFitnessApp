package uk.ac.tees.t7191599.agile_ica_0001;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;
import android.widget.EditText;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Created by t7207089 on 28/04/19.
 */
public class LogInActivityTest {
    @Rule
    public ActivityTestRule<LogInActivity> logInActivityActivityTestRule = new ActivityTestRule<LogInActivity>(LogInActivity.class);

    private LogInActivity logInActivity = null;

    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(SignUPActivity.class.getName(),null,false);

    Instrumentation.ActivityMonitor monitor2 = getInstrumentation().addMonitor(EventListActivity.class.getName(),null,false);


    @Before
    public void setUp() throws Exception {
        logInActivity = logInActivityActivityTestRule.getActivity();
    }

    @Test
    public void signUP() {

        assertNotNull(logInActivity.findViewById(R.id.signup_text));

        onView(withId(R.id.signup_text)).perform(click());

        Activity secondAct = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000);

        assertNotNull(secondAct);
    }

    @Test
    public void logIn()
    {
        logInActivity.findViewById(R.id.et_username);



        EditText et_username = (EditText) logInActivity.findViewById(R.id.et_username);
        EditText et_password = (EditText) logInActivity.findViewById(R.id.et_password);

        et_username.setText("thulak@mail.com");
        et_password.setText("1234567");

        onView(withId(R.id.login_text)).perform(click());

        Activity secondActt = getInstrumentation().waitForMonitor(monitor2);

        assertNotNull(secondActt);

    }


    @After
    public void tearDown() throws Exception {

        logInActivity = null;

    }


}