package com.app.interviewprepare.flow.terminal_operators.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onCompletion

class MainViewModel : ViewModel() {

    val data : LiveData<Int> = flow{
        for (i in 1..10){
            println("Display : $i")
            emit(i)
            delay(5000)
        }
    }.onCompletion {
        println("Display : Data completed")
    }.asLiveData()

}