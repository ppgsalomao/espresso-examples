package com.salomao.espresso.examples;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.salomao.espresso.examples.util.CustomMatchers.isNotDisplayed;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testScreenShouldShowAllElements() {
        onView(withText("Some Text to check using if it is been shown by value."))
                .check(matches(isDisplayed()));
        onView(withId(R.id.main_activity_text)).check(matches(isDisplayed()));
        onView(withId(R.id.main_activity_button)).check(matches(isDisplayed()));
    }

    @Test
    public void testButtonShouldHideTextView() {
        onView(withId(R.id.main_activity_button)).perform(click());
        onView(withId(R.id.main_activity_text)).check(matches(isNotDisplayed()));
    }
}
