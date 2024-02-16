package com.example.ngshuangyin_tp059869.guestlist

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Guestlist::class], version = 1)
abstract class GuestlistDatabase : RoomDatabase (){

    abstract val guestlistDao : GuestlistDao
    companion object {
        @Volatile
        private var INSTANCE: GuestlistDatabase? = null
        fun getInstance(context: Context): GuestlistDatabase {
            synchronized(this) {
                var instance : GuestlistDatabase? = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        GuestlistDatabase::class.java,
                        "guestlist_database"
                    ).build()
                }
                return instance
            }
        }
    }
}


