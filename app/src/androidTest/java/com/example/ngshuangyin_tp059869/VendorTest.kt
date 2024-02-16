package com.example.ngshuangyin_tp059869


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class VendorTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun vendorTest() {
        val bottomNavigationItemView = onView(
            allOf(
                withId(R.id.vendor), withContentDescription("Vendor"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.bottomNavigationView),
                        0
                    ),
                    4
                ),
                isDisplayed()
            )
        )
        bottomNavigationItemView.perform(click())

        val cardView = onView(
            allOf(
                withId(R.id.CardChinese),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.LinearLayout")),
                        1
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        cardView.perform(click())

        val materialButton = onView(
            allOf(
                withId(R.id.btnCVBack), withText("Back"),
                childAtPosition(
                    allOf(
                        withId(R.id.Act_CV_Linear_Layout),
                        childAtPosition(
                            withId(android.R.id.content),
                            0
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        materialButton.perform(click())

        val bottomNavigationItemView2 = onView(
            allOf(
                withId(R.id.vendor), withContentDescription("Vendor"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.bottomNavigationView),
                        0
                    ),
                    4
                ),
                isDisplayed()
            )
        )
        bottomNavigationItemView2.perform(click())

        val cardView2 = onView(
            allOf(
                withId(R.id.CardWestern),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.LinearLayout")),
                        1
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        cardView2.perform(click())

        pressBack()

        val cardView3 = onView(
            allOf(
                withId(R.id.CardMalay),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.LinearLayout")),
                        1
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        cardView3.perform(click())

        pressBack()

        val cardView4 = onView(
            allOf(
                withId(R.id.CardIndian),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.LinearLayout")),
                        1
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        cardView4.perform(click())

        val materialButton2 = onView(
            allOf(
                withId(R.id.btnCIBack), withText("Back"),
                childAtPosition(
                    allOf(
                        withId(R.id.Act_CI_Linear_Layout),
                        childAtPosition(
                            withId(android.R.id.content),
                            0
                        )
                    ),
                    0
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
