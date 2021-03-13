package com.example.kotlintest

val con = 1

sealed class SealedClass {
    object A : SealedClass()
    object B : SealedClass()
}

fun main() {
    var a = SealedClass.A
    val sealedClass = when (a) {
        SealedClass.A -> {
            println("SealedClass.A")
        }

        else -> {

        }
    }
}
