package com.example.ngshuangyin_tp059869.budget

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class BudgetViewModelFactory (private val repository: BudgetRepository):ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom((BudgetViewModel::class.java))){
            return BudgetViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown View Model Class")
    }

}