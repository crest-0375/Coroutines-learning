package org.example

import kotlinx.coroutines.*

fun main(){
    println("No other work can start right now.")
    runBlocking {
        launch{
            delay(1000)
            println("This is run blocking state.")
        }
        GlobalScope.launch {
            delay(500)
            println("This is Global scope.")
        }
        coroutineScope {
            delay(1500)
            println("This is from Coroutine scope")
        }
    }
    println("Now other work can start.")
}