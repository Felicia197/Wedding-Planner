package com.example.ngshuangyin_tp059869.budget


class BudgetRepository(private val dao: BudgetDao) {

    val budgets = dao.getAllBudget()

    suspend fun insert(budget: Budget): Long {
        return dao.insertBudget(budget)
    }

    suspend fun update(budget: Budget): Int{
        return dao.updateBudget(budget)
    }

    suspend fun delete(budget: Budget): Int{
        return dao.deleteBudget(budget)
    }

    suspend fun deleteAllB(): Int {
        return dao.deleteAllBudget()
    }
}