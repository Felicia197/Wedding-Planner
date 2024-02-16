package com.example.ngshuangyin_tp059869.budget

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface BudgetDao {

    @Insert (onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertBudget(budget: Budget): Long

    @Update
    suspend fun updateBudget(budget: Budget): Int

    @Delete
    suspend fun deleteBudget(budget: Budget): Int

    @Query("DELETE FROM budget")
    suspend fun deleteAllBudget(): Int

    @Query("SELECT * FROM budget")
    fun getAllBudget(): LiveData<List<Budget>>

}


