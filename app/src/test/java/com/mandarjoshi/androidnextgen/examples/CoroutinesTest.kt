package com.mandarjoshi.androidnextgen.examples

import junit.framework.TestCase
import kotlinx.coroutines.runBlocking

class CoroutinesTest : TestCase() {

    fun testMyFunction() {
        val coroutine = Coroutines()
        runBlocking {
            assertEquals(coroutine.myFunction(1000),2000)
        }
    }
}