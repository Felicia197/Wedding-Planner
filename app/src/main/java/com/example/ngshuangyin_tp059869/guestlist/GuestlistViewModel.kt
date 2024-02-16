package com.example.ngshuangyin_tp059869.guestlist

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ngshuangyin_tp059869.Event
import kotlinx.coroutines.launch

class GuestlistViewModel(private val repository: GuestlistRepository) : ViewModel(), Observable {

    val guestlists = repository.guestlists
    private var isUpdatedOrDelete = false
    private lateinit var guestlistToUpdateOrDelete : Guestlist

    @Bindable
    val inputGuestName = MutableLiveData<String>()
    @Bindable
    val inputRelationship = MutableLiveData<String>()
    @Bindable
    val btnSaveUpdateText = MutableLiveData<String>()
    @Bindable
    val btnClearDeleteText = MutableLiveData<String>()

    private val guestlistStatusMessage = MutableLiveData<Event<String>>()

    val message : LiveData<Event<String>>
        get() = guestlistStatusMessage

    init {
        btnSaveUpdateText.value = "Save"
        btnClearDeleteText.value = "Clear All"
    }

    fun saveOrUpdate(){

        // Validate Input
        if(inputGuestName.value == ""){
            guestlistStatusMessage.value = Event("Please Enter Guest's Name")
        } else if (inputRelationship.value == "") {
            guestlistStatusMessage.value = Event("Please Enter Your Relationship With Guest")
        } else {
            if(isUpdatedOrDelete){
                guestlistToUpdateOrDelete.guestName = inputGuestName.value!!
                guestlistToUpdateOrDelete.guestRelationship = inputRelationship.value!!
                update(guestlistToUpdateOrDelete)
            } else {
                val guestName = inputGuestName.value!!
                val relationship = inputRelationship.value!!
                insert(Guestlist(0,guestName,relationship))
                inputGuestName.value = ""
                inputRelationship.value = ""
            }
        }
    }

    fun ClearOrDelete(){
        if (isUpdatedOrDelete){
            delete(guestlistToUpdateOrDelete)
        } else {
            clearAllGL()
        }
    }

    fun insert(guestlist: Guestlist) = viewModelScope.launch {
        val newRowId = repository.insert(guestlist)
        if (newRowId > -1){
            guestlistStatusMessage.value = Event("Guest Added Successfully")
        } else {
            guestlistStatusMessage.value = Event("Ops! Error Occurred!")
        }

    }

    fun update(guestlist: Guestlist) = viewModelScope.launch {
        val numberOfRowsUpdate = repository.update(guestlist)
        if (numberOfRowsUpdate > 0) {
            inputGuestName.value = ""
            inputRelationship.value = ""
            isUpdatedOrDelete = false
            btnSaveUpdateText.value = "Save"
            btnClearDeleteText.value = "Clear All"
            guestlistStatusMessage.value = Event("$numberOfRowsUpdate Guest Updated Successfully")
        } else {
            guestlistStatusMessage.value = Event("Ops! Error Occurred!")
        }
    }

    fun delete(guestlist: Guestlist) = viewModelScope.launch {
        val numberOfRowsDelete = repository.delete(guestlist)
        if (numberOfRowsDelete > 0) {
            inputGuestName.value = ""
            inputRelationship.value = ""
            isUpdatedOrDelete = false
            btnSaveUpdateText.value = "Save"
            btnClearDeleteText.value = "Clear All"
            guestlistStatusMessage.value = Event("$numberOfRowsDelete Guest Deleted Successfully")
        } else {
            guestlistStatusMessage.value = Event("Ops! Error Occurred!")
        }
    }

    fun clearAllGL() = viewModelScope.launch {
        val numberOfRowsClear = repository.deleteAllGL()
        if (numberOfRowsClear > 0) {
            guestlistStatusMessage.value = Event("All Guests Deleted Successfully")
        } else {
            guestlistStatusMessage.value = Event("Ops! Error Occurred!")
        }
    }

    fun initUpdateAndDelete(guestlist: Guestlist){
        inputGuestName.value = guestlist.guestName
        inputRelationship.value = guestlist.guestRelationship
        isUpdatedOrDelete = true
        guestlistToUpdateOrDelete = guestlist
        btnSaveUpdateText.value = "Update"
        btnClearDeleteText.value = "Delete"
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }


}