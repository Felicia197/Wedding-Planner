package com.example.ngshuangyin_tp059869.checklist

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ChecklistDao {

    @Insert (onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertChecklist(checklist: Checklist): Long

    @Update
    suspend fun updateChecklist(checklist: Checklist): Int

    @Delete
    suspend fun deleteChecklist(checklist: Checklist): Int

    @Query("DELETE FROM checklist")
    suspend fun deleteAllChecklists(): Int

    @Query("SELECT * FROM checklist")
    fun getAllChecklist(): LiveData<List<Checklist>>

}



