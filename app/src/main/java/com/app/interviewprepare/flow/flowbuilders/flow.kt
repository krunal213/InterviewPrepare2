package com.app.interviewprepare.flow.flowbuilders

import kotlinx.coroutines.flow.flow

suspend fun main() {
    flow {
        emit(1)
        kotlinx.coroutines.delay(1000)
        emit(2)
    }.collect{
        println("flow : $it")
    }
}