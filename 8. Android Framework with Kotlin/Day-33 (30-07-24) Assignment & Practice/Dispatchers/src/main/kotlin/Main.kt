package org.example

import kotlinx.coroutines.*

fun main() = runBlocking {
    launch(Dispatchers.IO) {
        println("IO: ${Thread.currentThread().name}")
    }
    launch(Dispatchers.Default) {
        println("Default: ${Thread.currentThread().name}")
    }
    // Use Dispatchers.Default as a fallback
    launch(Dispatchers.Default) {
        println("Fallback: ${Thread.currentThread().name}")
    }
}
