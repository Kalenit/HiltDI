package com.example.hiltcarengine

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class CarViewModel @Inject constructor(
    private val engine: Engine
): ViewModel() {

    private val _engineStatus = MutableLiveData<String>()
    val engineState: LiveData<String> = _engineStatus

    fun startCar(){
        val status = engine.start()
        _engineStatus.value= status
    }
}