package com.example.allermi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.allermi.model.IntroModel
import kotlinx.coroutines.launch

class IntroViewModel() : ViewModel() {
    private val introModel = IntroModel()
    private val _animString = MutableLiveData(StringBuilder("세상"))


    val animString: LiveData<StringBuilder> = _animString


    fun addAnimString(string: String){
        viewModelScope.launch {
            _animString.value = animString.value?.append(string)
        }
    }
}