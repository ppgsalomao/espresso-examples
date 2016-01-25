package com.salomao.espresso.examples.util;

import android.support.test.espresso.matcher.ViewMatchers;
import android.view.View;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;

public class CustomMatchers {

    public static Matcher<View> isNotDisplayed() {
        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("is not displayed on the screen to the user");
            }

            @Override
            public boolean matchesSafely(View view) {
                return withEffectiveVisibility(ViewMatchers.Visibility.GONE).matches(view);
            }
        };
    }
}
