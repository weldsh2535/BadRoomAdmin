package com.version1.badroomAdmin.ui.Dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is gallery Fragment"
    }
    val text: LiveData<String> = _text
    val fullname = MutableLiveData<String>()
    val kebele = MutableLiveData<String>()
    val phonenumber = MutableLiveData<String>()
    val roomNumber = MutableLiveData<String>()
    val userId = MutableLiveData<String>()
    val images = MutableLiveData<String>()
    val registerDate = MutableLiveData<String>()
    val exitDate = MutableLiveData<String>()
}