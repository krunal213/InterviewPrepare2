package com.app.interviewprepare.flow.terminal_operators

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() {
    val flow = flow<Int> {
        delay(1000)

        println("Emitting First")
    }

    runBlocking {
        val first = flow.firstOrNull()
        println("Collected $first")
    }
}