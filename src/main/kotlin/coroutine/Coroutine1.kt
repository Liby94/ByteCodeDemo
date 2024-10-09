package org.example.coroutine

import kotlinx.coroutines.*
import java.time.LocalDate
import java.time.LocalDateTime
import kotlin.math.log

@OptIn(DelicateCoroutinesApi::class)
fun main() {
    getDate()
    val blocking = runBlocking {
        GlobalScope.launch {
            log(321)
            delay(1000)
            log("launch")
        }
    }
    Thread.sleep(5 * 1000)
}


private fun log(msg: Any) {
    println("[${getDate()}] [ThreadName:${Thread.currentThread().name}] $msg")
}

private fun getDate(): String = LocalDateTime.now().toString()