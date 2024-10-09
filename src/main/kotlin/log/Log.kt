package org.example.log

import java.time.LocalDateTime

fun Any.log() {
    println("${getLocalDateTime()} ${getCurrentThreadName()} ${this}")
}

fun Any.contract(any: Any, useSpace: Boolean = true) =
    this.toString()
    .plus(if (useSpace) " " else "")
    .plus(any.toString())

fun getLocalDateTime() = LocalDateTime.now().toString()

fun getCurrentThreadName(): String = Thread.currentThread().name