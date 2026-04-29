package com.app.interviewprepare.flow.terminal_operators

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlin.coroutines.EmptyCoroutineContext

fun main() {
    val flow = flow {
        delay(1000)

        println("Emitting First")
        emit(1)

        delay(1000)

        println("Emitting Second")
        emit(2)
    }

    flow
        .onEach { println("Data $it") }
        .launchIn(CoroutineScope(EmptyCoroutineContext))

    Thread.sleep(3000)
}