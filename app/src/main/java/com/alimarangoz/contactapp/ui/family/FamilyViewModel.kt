package com.alimarangoz.contactapp.ui.family

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FamilyViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is family fragment"
    }
    val text: LiveData<String> = _text
}