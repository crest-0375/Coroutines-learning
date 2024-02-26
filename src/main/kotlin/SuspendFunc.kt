package org.example

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

var functionCall = 0

fun main() {
    GlobalScope.launch { hello() }
    GlobalScope.launch { improve() }

    Thread.sleep(2000)
    println("Total $functionCall calls called.")
}

suspend fun hello() {
    delay(5000L)
    println("World")
    functionCall++
}

suspend fun improve() {
    delay(1000L)
    println("Suspend functions are cool.")
    functionCall++
}