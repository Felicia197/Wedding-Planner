package com.example.ngshuangyin_tp059869

import org.junit.After
import org.junit.Before
import org.junit.Test

class UnitTestChecklistValidate {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun taskEmpty(){
        val task = ""
        val assert=UserUtils.checklistValidate(task,"20/12/2022")
        assert(assert=="Please Enter Task")
    }

    @Test
    fun dateEmpty(){
        val date = ""
        val assert=UserUtils.checklistValidate("Buy Flower", date)
        assert(assert=="Please Enter Date")
    }
}
