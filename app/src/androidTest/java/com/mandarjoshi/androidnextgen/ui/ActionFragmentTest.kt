package com.mandarjoshi.androidnextgen.ui

import android.content.Intent
import androidx.core.os.bundleOf
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.mandarjoshi.androidnextgen.MainActivity
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ActionFragmentTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testEventFragment() {
        val fragmentArgs = bundleOf("selectedListItem" to 0)
        //mActivityTestRule.launchActivity(Intent())
        val scenario = launchFragmentInContainer<ActionFragment>(fragmentArgs)
        //scenario.recreate()
        assertTrue(true)
    }
}