package com.example.ngshuangyin_tp059869

import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class HomeTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun homeTest() {
        val materialButton = onView(
            allOf(
                withId(R.id.btnStart), withText("CLICK ME TO EDIT"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.frame_layout),
                        0
                    ),
                    8
                ),
                isDisplayed()
            )
        )
        materialButton.perform(click())

        val appCompatEditText = onView(
            allOf(
                withId(R.id.etvName),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.frame_layout),
                        0
                    ),
                    5
                ),
                isDisplayed()
            )
        )
        appCompatEditText.perform(replaceText("Rose"), closeSoftKeyboard())

        val appCompatEditText2 = onView(
            allOf(
                withId(R.id.etvPartnerName),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.frame_layout),
                        0
                    ),
                    6
                ),
                isDisplayed()
            )
        )
        appCompatEditText2.perform(replaceText("Tim"), closeSoftKeyboard())

        val appCompatEditText3 = onView(
            allOf(
                withId(R.id.etvMarriageDate),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.frame_layout),
                        0
                    ),
                    7
                ),
                isDisplayed()
            )
        )
        appCompatEditText3.perform(replaceText("20/12/2022"), closeSoftKeyboard())

        val materialButton2 = onView(
            allOf(
                withId(R.id.btnStart), withText("CLICK ME TO EDIT"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.frame_layout),
                        0
                    ),
                    8
                ),
                isDisplayed()
            )
        )
        materialButton2.perform(click())
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
