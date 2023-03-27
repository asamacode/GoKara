package com.example.firstapplication

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    @Rule @JvmField
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun clickLoginButton_openLoginUI() {
        onView(withId(R.id.btnLogin)).perform(click())
        onView(withId(R.id.tvLogin)).check(matches(isDisplayed()))
        onView(withId(R.id.tvLogin)).check(matches(withText("Login")))
    }
}
