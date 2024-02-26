package org.example

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val myHandler = CoroutineExceptionHandler{coroutineContext, throwable ->
            println("Exception handled : ${throwable.localizedMessage}")
        }
        val job = GlobalScope.launch(myHandler) {
            println("Throwing exception from the job.")
            throw IndexOutOfBoundsException("IOB exception")
        }
        job.join()
    }
}