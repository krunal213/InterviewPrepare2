package com.app.interviewprepare.flow.intermediate_operators

import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.withIndex

suspend fun main() {
    flowOf(1,2,3,4,5,6)
        .withIndex()
        .collect{
            println("Data $it")
        }
}