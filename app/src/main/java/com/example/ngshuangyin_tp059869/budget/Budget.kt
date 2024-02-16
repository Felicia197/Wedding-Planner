package com.example.ngshuangyin_tp059869.budget

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "budget")
data class Budget (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="budget_id")
    var budgetid : Int,

    @ColumnInfo(name="budget_details")
    var budgetDetails : String,

    @ColumnInfo(name="budget_amount")
    var budgetAmount : String

)

