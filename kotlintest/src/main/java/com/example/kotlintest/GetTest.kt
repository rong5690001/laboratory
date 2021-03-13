package com.example.kotlintest

/**
 * @Author: chen.huarong
 * @Description:
 * @Data: 2/2/21
 */
class GetTest {
    val isOk:Boolean
        get() = Comm.isOk
}

object Comm {
    var isOk = true
}

fun main() {
    val getTest = GetTest()
    println(getTest.isOk)
    Comm.isOk = false
    println(getTest.isOk)
}