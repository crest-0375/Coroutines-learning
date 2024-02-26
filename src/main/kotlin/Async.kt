package org.example

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

fun main() {
    runBlocking {
        val fDeferred = async { getFirstVal() }
        val sDeferred = async { getSecondVal() }

        println("Doing some processing here.")
        delay(500L)
        println("Waiting for values.")

        val firstVal = fDeferred.await()
        val secondVal = sDeferred.await()

        println("The total is ${firstVal + secondVal}")
    }
}

suspend fun getFirstVal(): Int {
    delay(5000L)
    val value = Random.nextInt(0,10)
    println("Returning first value $value")
    return value
}

suspend fun getSecondVal(): Int {
    delay(1000L)
    val value = Random.nextInt(10,20)
    println("Returning second value $value")
    return value
}
