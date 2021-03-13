package com.example.kotlintest.dsl

class DSLTest {
    fun start(): String = "ok"



//    val result =
//        html {
//
//        }
//
//
//
//
//
//    class Html():TagWithText("html") {
//        fun head(init:Html.() -> Unit) = {
//            println("<header>${init}</header>")
//        }
//    }
}

fun main() {
    println(DSLTest().start())
}