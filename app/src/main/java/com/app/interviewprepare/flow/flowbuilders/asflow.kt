package com.app.interviewprepare.flow.flowbuilders

import kotlinx.coroutines.flow.asFlow

suspend fun main() {
    listOf(1,2,3,4).asFlow().collect{
        println("asFlow : $it")
    }
}