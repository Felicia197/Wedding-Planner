package com.example.ngshuangyin_tp059869.checklist

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "checklist")
data class Checklist (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="checklist_id")
    var checklistid : Int,

    @ColumnInfo(name="task")
    var task : String,

    @ColumnInfo(name="date")
    var date : String

)


