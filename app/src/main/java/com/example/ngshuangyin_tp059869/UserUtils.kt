package com.example.ngshuangyin_tp059869

object UserUtils {

    fun homeValidate (name: String, partnerName: String, marriageDate: String): String? {

        if (name.isEmpty()) return "Please Enter Data To Edit!"
        if (partnerName.isEmpty()) return "Please Enter Data To Edit!"
        if (marriageDate.isEmpty()) return "Please Enter Data To Edit!"

        return null
    }

    fun checklistValidate (task: String, date: String): String? {

        if (task.isEmpty()) return "Please Enter Task"
        if (date.isEmpty()) return "Please Enter Date"

        return null
    }
}

