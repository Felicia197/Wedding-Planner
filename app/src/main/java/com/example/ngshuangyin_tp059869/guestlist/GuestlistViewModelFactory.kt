package com.example.ngshuangyin_tp059869.guestlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class GuestlistViewModelFactory (private val repository: GuestlistRepository):ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom((GuestlistViewModel::class.java))){
            return GuestlistViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown View Model Class")
    }

}