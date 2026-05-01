package com.app.interviewprepare.flow.intermediate_operators

import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flowOf

suspend fun main() {
    flowOf(1,2,3,4,5)
        .filter { it % 2 == 0 }
        .collect{
            println("Data $it")
        }
}