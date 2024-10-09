package org.example.Recursion

import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

val obj = Any()

fun main() {

    thread {
        sigma(1)
    }
    runBlocking {
        while (true) {

        }
    }
}

private fun sigma(n: Int): Int {
    println("current n value is: ${n}")
    return n + sigma(n + 1)
}