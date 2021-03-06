package com.example.uitestdemo

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Ankit Bajaj on 22-06-2020.
 */

// For new androidx test dependancy, we are using new runner as AndroidJUnit4ClassRunner
@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    // So there are the few steps, First launch the test activity
    // Then check
    @Test
    fun is_ActivityInView() {

        // To launch the activity inside method
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        //verify the UI
        // Finding view and then checking is it displayed
        onView(withId(R.id.main)).check(matches(isDisplayed()))

        // Test Visibility test next button

    }

    @Test
    fun test_visibility_title_next_button() {
        // To launch the activity inside method
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        // Title label Visibility
        onView(withId(R.id.activity_main_title)).check(matches(isDisplayed()))

        // Next button Visibility - way 1 to check visibility
        // onView(withId(R.id.button_next_activity)).check(matches(isDisplayed()))
        //Or - way 2 to check visibility
        onView(withId(R.id.button_next_activity)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }

    @Test
    fun test_isTitleTextDisplayed() {
        // To launch the activity inside method
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.activity_main_title)).check(matches(withText(R.string.text_mainactivity)))
    }

    @Test
    fun test_navToSecondaryActivity() {
        // To launch the activity inside method
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        // perform on click on the button
        onView(withId(R.id.button_next_activity)).perform(click())

        // Once navigate to second activity then verify the UI
        onView(withId(R.id.secondary)).check(matches(isDisplayed()))
    }

    @Test
    fun test_backpressToMainActivity() {
        // To launch the activity inside method
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        // perform on click on the button
        onView(withId(R.id.button_next_activity)).perform(click())

        // Once navigate to second activity then verify the UI
        onView(withId(R.id.secondary)).check(matches(isDisplayed()))

        // On Secondary activity press back button
       // onView(withId(R.id.button_back)).perform(click()) // method 1
        pressBack() // method 2

        // Verfiy MainActivity view
        onView(withId(R.id.main)).check(matches(isDisplayed()))

    }
}