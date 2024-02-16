package com.example.ngshuangyin_tp059869.budget

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ngshuangyin_tp059869.Event
import kotlinx.coroutines.launch

class BudgetViewModel(private val repository: BudgetRepository) : ViewModel(), Observable {

    val budgets = repository.budgets
    private var isUpdatedOrDelete = false
    private lateinit var budgetToUpdateOrDelete : Budget

    @Bindable
    val inputBudgetDetails = MutableLiveData<String>()
    @Bindable
    val inputBudgetAmount = MutableLiveData<String>()
    @Bindable
    val btnSaveUpdateText = MutableLiveData<String>()
    @Bindable
    val btnClearDeleteText = MutableLiveData<String>()

    private val budgetStatusMessage = MutableLiveData<Event<String>>()

    val message : LiveData<Event<String>>
        get() = budgetStatusMessage

    init {
        btnSaveUpdateText.value = "Save"
        btnClearDeleteText.value = "Clear All"
    }

    fun saveOrUpdate(){

        // Validate Input
        if(inputBudgetDetails.value == ""){
            budgetStatusMessage.value = Event("Please Enter Budget Details")
        } else if (inputBudgetAmount.value == "") {
            budgetStatusMessage.value = Event("Please Enter Budget Amount")
        } else {
            if(isUpdatedOrDelete){
                budgetToUpdateOrDelete.budgetDetails = inputBudgetDetails.value!!
                budgetToUpdateOrDelete.budgetAmount = inputBudgetAmount.value!!
                update(budgetToUpdateOrDelete)
            } else {
                val budgetDetails = inputBudgetDetails.value!!
                val budgetAmount = inputBudgetAmount.value!!
                insert(Budget(0,budgetDetails,budgetAmount))
                inputBudgetDetails.value = ""
                inputBudgetAmount.value = ""
            }
        }
    }

    fun ClearOrDelete(){
        if (isUpdatedOrDelete){
            delete(budgetToUpdateOrDelete)
        } else {
            clearAllB()
        }
    }

    fun insert(budget: Budget) = viewModelScope.launch {
        val newRowId = repository.insert(budget)
        if (newRowId > -1){
            budgetStatusMessage.value = Event("Added Successfully")
        } else {
            budgetStatusMessage.value = Event("Ops! Error Occurred!")
        }

    }

    fun update(budget: Budget) = viewModelScope.launch {
        val numberOfRowsUpdate = repository.update(budget)
        if (numberOfRowsUpdate > 0) {
            inputBudgetDetails.value = ""
            inputBudgetAmount.value = ""
            isUpdatedOrDelete = false
            btnSaveUpdateText.value = "Save"
            btnClearDeleteText.value = "Clear All"
            budgetStatusMessage.value = Event("$numberOfRowsUpdate Budget Detail Updated Successfully")
        } else {
            budgetStatusMessage.value = Event("Ops! Error Occurred!")
        }
    }

    fun delete(budget: Budget) = viewModelScope.launch {
        val numberOfRowsDelete = repository.delete(budget)
        if (numberOfRowsDelete > 0) {
            inputBudgetDetails.value = ""
            inputBudgetAmount.value = ""
            isUpdatedOrDelete = false
            btnSaveUpdateText.value = "Save"
            btnClearDeleteText.value = "Clear All"
            budgetStatusMessage.value = Event("$numberOfRowsDelete Budget Detail Deleted Successfully")
        } else {
            budgetStatusMessage.value = Event("Ops! Error Occurred!")
        }
    }

    fun clearAllB() = viewModelScope.launch {
        val numberOfRowsClear = repository.deleteAllB()
        if (numberOfRowsClear > 0) {
            budgetStatusMessage.value = Event("All Budget Details Deleted Successfully")
        } else {
            budgetStatusMessage.value = Event("Ops! Error Occurred!")
        }
    }

    fun initUpdateAndDelete(budget: Budget){
        inputBudgetDetails.value = budget.budgetDetails
        inputBudgetAmount.value = budget.budgetAmount
        isUpdatedOrDelete = true
        budgetToUpdateOrDelete = budget
        btnSaveUpdateText.value = "Update"
        btnClearDeleteText.value = "Delete"
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }


}