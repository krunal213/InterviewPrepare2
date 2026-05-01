package com.app.interviewprepare.flow.intermediate_operators

import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.take

suspend fun main() {
    flowOf(1,2,3,4,5,6)
        .take(4)
        .collect{
            println("Data $it")
        }
}