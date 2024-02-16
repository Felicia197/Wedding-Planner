package com.example.ngshuangyin_tp059869.checklist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ChecklistViewModelFactory (private val repository: ChecklistRepository):ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom((ChecklistViewModel::class.java))){
            return ChecklistViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown View Model Class")
    }

}
