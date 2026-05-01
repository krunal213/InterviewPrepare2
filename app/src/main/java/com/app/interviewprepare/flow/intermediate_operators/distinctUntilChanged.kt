package com.app.interviewprepare.flow.intermediate_operators

import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flowOf

suspend fun main() {
    flowOf(1,2,3,3,4,5,1,6)
        .distinctUntilChanged()
        .collect{
            print(" $it")
        }
}