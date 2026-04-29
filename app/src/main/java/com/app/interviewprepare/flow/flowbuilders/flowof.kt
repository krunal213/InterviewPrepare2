package com.app.interviewprepare.flow.flowbuilders

import kotlinx.coroutines.flow.flowOf

suspend fun main() {
    flowOf(1).collect{
        println("flowOf : $it")
    }
}