package com.example.ngshuangyin_tp059869

import org.junit.After
import org.junit.Before
import org.junit.Test

class UnitTestHomePageValidate {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun nameEmpty(){
        val name = ""
        val assert=UserUtils.homeValidate(name,"John","20/12/2022")
        assert(assert=="Please Enter Data To Edit!")
    }

    @Test
    fun partnerNameEmpty(){
        val partnerName = ""
        val assert=UserUtils.homeValidate("Rose", partnerName,"20/12/2022")
        assert(assert=="Please Enter Data To Edit!")
    }

    @Test
    fun marriageDateEmpty(){
        val marriageDate = ""
        val assert=UserUtils.homeValidate("Rose","John",marriageDate)
        assert(assert=="Please Enter Data To Edit!")
    }

}
