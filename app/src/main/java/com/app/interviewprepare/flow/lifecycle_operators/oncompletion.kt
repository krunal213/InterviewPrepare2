package com.app.interviewprepare.flow.lifecycle_operators

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlin.coroutines.EmptyCoroutineContext

suspend fun main() {
    val flow = flow {
        for (i in 1..5){
            delay(1000)

            emit(i)
        }
    }
    flow
        .onEach { println("Data $it") }
        .onCompletion { println("Ending Flow") }
        .launchIn(CoroutineScope(EmptyCoroutineContext))
    delay(6000)
}