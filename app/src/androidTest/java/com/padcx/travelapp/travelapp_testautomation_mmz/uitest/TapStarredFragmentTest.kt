package com.padcx.travelapp.travelapp_testautomation_mmz.uitest

import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.padcx.travelapp.travelapp_testautomation_mmz.R
import com.padcx.travelapp.travelapp_testautomation_mmz.activities.MainActivity
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Myint Myint Zaw on 7/18/2020.
 */

@RunWith(AndroidJUnit4ClassRunner::class)
class TapStarredFragmentTest {
    private val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Before
    open fun setUp() {
        activityTestRule.launchActivity(Intent())
    }

    @Test
    fun checkSearchFragmentVisible_navigateSearchFragment() {

        onView(withId(R.id.action_star)).perform(click())
        onView(withId(R.id.frag_starred))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_starred))
            .check(matches(withText("Starred Fragment")))

    }
}