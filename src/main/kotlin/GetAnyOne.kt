package org.example

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

suspend fun function1(): Int {
    delay(1000) // Simulating some work
    return 1
}

suspend fun function2(): Int {
    delay(500) // Simulating some work
    return 2
}

fun main() = runBlocking {
    val time = measureTimeMillis {
        val result1 = async { function1() }
        val result2 = async { function2() }

        val firstResult = listOf(result1, result2).awaitAll()
        println("First result: $firstResult")
    }
    println("Total time: $time ms")
}

//suspend fun <T> List<Deferred<T>>.awaitAny(): T {
//    // Await for the first completed coroutine
//    val completed = awaitFirstOrNull { it.isCompleted }
//    return completed?.await() ?: throw NoSuchElementException("No elements have completed")
//}
