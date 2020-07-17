package com.padcx.travelapp.travelapp_testautomation_mmz.uitest

import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.padcx.travelapp.travelapp_testautomation_mmz.R
import com.padcx.travelapp.travelapp_testautomation_mmz.activities.TourDetailActivity
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Myint Myint Zaw on 7/18/2020.
 */
@RunWith(AndroidJUnit4ClassRunner::class)
class DetailActivityTest {
    private val activityTestRule = ActivityTestRule<TourDetailActivity>(TourDetailActivity::class.java)

    @Before
    open fun setUp() {
        activityTestRule.launchActivity(Intent())
    }

    @Test
    fun checkTourDetailActivityVisible() {

        Espresso.onView(ViewMatchers.withId(R.id.rv_resort_image))
            .check(matches(ViewMatchers.isDisplayed()))
    }
}