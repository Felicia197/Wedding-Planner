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
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class GuestlistTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun guestlistTest() {
        val bottomNavigationItemView = onView(
            allOf(
                withId(R.id.guestlist), withContentDescription("Guestlist"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.bottomNavigationView),
                        0
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        bottomNavigationItemView.perform(click())

        val appCompatEditText = onView(
            allOf(
                withId(R.id.etvGuestlistName),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.frame_layout),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatEditText.perform(replaceText("Sam"), closeSoftKeyboard())

        val appCompatEditText2 = onView(
            allOf(
                withId(R.id.etvGuestlistRelationship),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.frame_layout),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatEditText2.perform(replaceText("Father"), closeSoftKeyboard())

        val materialButton = onView(
            allOf(
                withId(R.id.btnSaveUpdate), withText("Save"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.LinearLayout")),
                        3
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        materialButton.perform(click())

        val linearLayout = onView(
            allOf(
                withId(R.id.guestlist_item_layout),
                childAtPosition(
                    allOf(
                        withId(R.id.cardViewGuestlist),
                        childAtPosition(
                            withId(R.id.Guestlist_Linear_Layout),
                            0
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        linearLayout.perform(click())

        val appCompatEditText3 = onView(
            allOf(
                withId(R.id.etvGuestlistRelationship), withText("Father"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.frame_layout),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatEditText3.perform(click())

        val appCompatEditText4 = onView(
            allOf(
                withId(R.id.etvGuestlistRelationship), withText("Father"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.frame_layout),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatEditText4.perform(replaceText("Uncle"))

        val appCompatEditText5 = onView(
            allOf(
                withId(R.id.etvGuestlistRelationship), withText("Uncle"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.frame_layout),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatEditText5.perform(closeSoftKeyboard())

        val materialButton2 = onView(
            allOf(
                withId(R.id.btnSaveUpdate), withText("Update"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.LinearLayout")),
                        3
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        materialButton2.perform(click())

        val materialButton3 = onView(
            allOf(
                withId(R.id.btnClearDelete), withText("Clear All"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.LinearLayout")),
                        3
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        materialButton3.perform(click())
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
