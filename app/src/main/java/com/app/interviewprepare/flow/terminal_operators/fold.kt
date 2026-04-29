package com.app.interviewprepare.flow.terminal_operators

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.fold
import kotlinx.coroutines.flow.toSet
import kotlinx.coroutines.runBlocking

fun main() {
    val flow = flow {
        delay(1000)

        println("Emitting First")
        emit(1)

        delay(1000)

        println("Emitting Second")
        emit(2)

        delay(1000)

        println("Emitting Third")
        emit(2)
    }

    runBlocking {
        val foldValue = flow.fold(5){ initialValue, emittedValue ->
            initialValue + emittedValue
        }
        println(foldValue)
    }
}