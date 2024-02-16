package com.example.ngshuangyin_tp059869.guestlist

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface GuestlistDao {

    @Insert (onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertGuestlist(guestlist: Guestlist): Long

    @Update
    suspend fun updateGuestlist(guestlist: Guestlist): Int

    @Delete
    suspend fun deleteGuestlist(guestlist: Guestlist): Int

    @Query("DELETE FROM guestlist")
    suspend fun deleteAllGuestlists(): Int

    @Query("SELECT * FROM guestlist")
    fun getAllGuestlist(): LiveData<List<Guestlist>>

}


