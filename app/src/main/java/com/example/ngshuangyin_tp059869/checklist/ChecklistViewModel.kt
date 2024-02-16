package com.example.ngshuangyin_tp059869.checklist

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ngshuangyin_tp059869.Event
import kotlinx.coroutines.launch

class ChecklistViewModel(private val repository: ChecklistRepository) : ViewModel(), Observable {

    val checklists = repository.checklists
    private var isUpdatedOrDelete = false
    private lateinit var checklistToUpdateOrDelete : Checklist

    @Bindable
    val inputTask = MutableLiveData<String>()
    @Bindable
    val inputDate = MutableLiveData<String>()
    @Bindable
    val btnSaveUpdateText = MutableLiveData<String>()
    @Bindable
    val btnClearDeleteText = MutableLiveData<String>()

    private val checklistStatusMessage = MutableLiveData<Event<String>>()

    val message : LiveData<Event<String>>
    get() = checklistStatusMessage
    
    init {
        btnSaveUpdateText.value = "Save"
        btnClearDeleteText.value = "Clear All"
    }

    fun saveOrUpdate(){

        // Validate Input
        if(inputTask.value == ""){
            checklistStatusMessage.value = Event("Please Enter Task")
        } else if (inputDate.value == "") {
            checklistStatusMessage.value = Event("Please Enter Date")
        } else {
            if(isUpdatedOrDelete){
                checklistToUpdateOrDelete.task = inputTask.value!!
                checklistToUpdateOrDelete.date = inputDate.value!!
                update(checklistToUpdateOrDelete)
            } else {
                val task = inputTask.value!!
                val date = inputDate.value!!
                insert(Checklist(0,task,date))
                inputTask.value = ""
                inputDate.value = ""
            }
        }
    }

    fun ClearOrDelete(){
        if (isUpdatedOrDelete){
            delete(checklistToUpdateOrDelete)
        } else {
            clearAllCL()
        }
    }

    fun insert(checklist: Checklist) = viewModelScope.launch {
        val newRowId = repository.insert(checklist)
        if (newRowId > -1){
            checklistStatusMessage.value = Event("Task Added Successfully")
        } else {
            checklistStatusMessage.value = Event("Ops! Error Occurred!")
        }

    }

    fun update(checklist: Checklist) = viewModelScope.launch {
        val numberOfRowsUpdate = repository.update(checklist)
        if (numberOfRowsUpdate > 0) {
            inputTask.value = ""
            inputDate.value = ""
            isUpdatedOrDelete = false
            btnSaveUpdateText.value = "Save"
            btnClearDeleteText.value = "Clear All"
            checklistStatusMessage.value = Event("$numberOfRowsUpdate Task Updated Successfully")
        } else {
            checklistStatusMessage.value = Event("Ops! Error Occurred!")
        }
    }

    fun delete(checklist: Checklist) = viewModelScope.launch {
        val numberOfRowsDelete = repository.delete(checklist)
        if (numberOfRowsDelete > 0) {
            inputTask.value = ""
            inputDate.value = ""
            isUpdatedOrDelete = false
            btnSaveUpdateText.value = "Save"
            btnClearDeleteText.value = "Clear All"
            checklistStatusMessage.value = Event("$numberOfRowsDelete Task Deleted Successfully")
        } else {
            checklistStatusMessage.value = Event("Ops! Error Occurred!")
        }
    }

    fun clearAllCL() = viewModelScope.launch {
        val numberOfRowsClear = repository.deleteAllCL()
        if (numberOfRowsClear > 0) {
            checklistStatusMessage.value = Event("All Tasks Deleted Successfully")
        } else {
            checklistStatusMessage.value = Event("Ops! Error Occurred!")
        }
    }

    fun initUpdateAndDelete(checklist: Checklist){
        inputTask.value = checklist.task
        inputDate.value = checklist.date
        isUpdatedOrDelete = true
        checklistToUpdateOrDelete = checklist
        btnSaveUpdateText.value = "Update"
        btnClearDeleteText.value = "Delete"
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }


}