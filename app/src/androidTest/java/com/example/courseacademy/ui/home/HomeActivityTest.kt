package com.example.courseacademy.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.courseacademy.R
import com.example.courseacademy.utils.DataDummy
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class HomeActivityTest {

    private val dummyCourse = DataDummy.generateDummyCourse()

    @Before
    fun setUp() {
        ActivityScenario.launch(HomeActivity::class.java)
    }

    @Test
    fun loadDataCourses() {
        onView(withId(R.id.rv_academy)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyCourse.size
            )
        )

        onView(
            withId(R.id.rv_academy)
        ).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
    }

    @Test
    fun loadModule() {
        onView(withId(R.id.rv_academy)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )

        onView(withId(R.id.btn_start)).perform(click())
        onView(withId(R.id.rv_module)).check(matches(isDisplayed()))
    }

    @Test
    fun loadDetailModule() {
        onView(withId(R.id.rv_academy)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )

        onView(withId(R.id.btn_start)).perform(click())
        onView(withId(R.id.rv_module)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )

        onView(withId(R.id.web_view)).check(matches(isDisplayed()))
    }

    @Test
    fun loadBookmarks() {
        onView(withText("Bookmark")).perform(click())
        onView(withId(R.id.rv_bookmark)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_bookmark)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyCourse.size
            )
        )
    }
}