package com.example.ngshuangyin_tp059869.checklist

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Checklist::class], version = 1)
abstract class ChecklistDatabase : RoomDatabase (){

    abstract val checklistDao : ChecklistDao
    companion object {
        @Volatile
        private var INSTANCE: ChecklistDatabase? = null
        fun getInstance(context: Context): ChecklistDatabase {
            synchronized(this) {
                var instance : ChecklistDatabase? = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ChecklistDatabase::class.java,
                        "checklist_database"
                    ).build()
                }
                return instance
            }
        }
    }
}

