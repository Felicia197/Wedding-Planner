package com.example.ngshuangyin_tp059869.guestlist

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "guestlist")
data class Guestlist (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="guestlist_id")
    var guestlistid : Int,

    @ColumnInfo(name="guest_name")
    var guestName : String,

    @ColumnInfo(name="relationship")
    var guestRelationship : String

)


