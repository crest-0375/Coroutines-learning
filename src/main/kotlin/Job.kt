package org.example

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val job1 = launch {
            println("Job 1 launched.")
//            delay(2000)
            println("Job 1 did it work.")

            val job2 = launch {
                println("Job 2 launched.")
                delay(2000)
                println("Job 2 did it work.")
            }
        }

        job1.invokeOnCompletion {
            println("Job 1 is completed")
        }

        delay(500L)
        job1.cancel()
        println("Job1 was canceled.")
    }
}