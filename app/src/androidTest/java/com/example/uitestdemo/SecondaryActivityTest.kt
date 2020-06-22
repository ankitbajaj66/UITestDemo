package com.example.uitestdemo

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Ankit Bajaj on 22-06-2020.
 */
@RunWith(AndroidJUnit4ClassRunner::class)
class SecondaryActivityTest {

    // This is the test rule called before each function
    @get : Rule
    val activityRule = ActivityScenarioRule(SecondaryActivity::class.java)

    @Test
    fun is_ActivityInView() {
        onView(withId(R.id.secondary)).check(matches(isDisplayed()))
    }

    @Test
    fun test_VisibilityBackButton() {
        onView(withId(R.id.button_back)).check(matches(isDisplayed()))
    }

    @Test
    fun is_TitleTextDisplayed() {
        onView(withId(R.id.activity_secondary_title)).check(matches(withText(R.string.text_secondaryactivity)))
    }
}