package com.padcx.travelapp.travelapp_testautomation_mmz.uitest

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.padcx.travelapp.travelapp_testautomation_mmz.R
import com.padcx.travelapp.travelapp_testautomation_mmz.activities.MainActivity
import com.padcx.travelapp.travelapp_testautomation_mmz.views.viewholders.CountryViewHolder
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Myint Myint Zaw on 7/18/2020.
 */
@RunWith(AndroidJUnit4ClassRunner::class)
class HomeFragmentGoToDetailTest {
    private val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Before
    open fun setUp() {
        activityTestRule.launchActivity(Intent())
    }

    @Test
    fun tapHomeFragment_checkHomeFragmentVisible_navigateToBurgerDetails() {
        onView(withId(R.id.action_home)).perform(ViewActions.click())
        onView(withId(R.id.home_fragment)).check(matches(isDisplayed()))

        onView(withId(R.id.rv_country))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<CountryViewHolder>(0,
                    ViewActions.click()
                ))

        onView(withId(R.id.tv_content)).check(matches(isDisplayed()))

    }
}