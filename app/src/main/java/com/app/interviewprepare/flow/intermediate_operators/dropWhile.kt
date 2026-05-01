package com.app.interviewprepare.flow.intermediate_operators

import kotlinx.coroutines.flow.dropWhile
import kotlinx.coroutines.flow.flowOf

suspend fun main() {
    flowOf(1,2,3,4,5,6)
        .dropWhile { it < 3 }
        .collect{
            println("Data $it")
        }
}