package com.example.kotlintest

class CollectionsTest {

    val _list = arrayListOf('a', 'b', 'c', 'd')



}

fun main() {
    val _list = arrayListOf('a', 'b', 'c', 'd', 'g', 'e')

    _list.sortedDescending().forEach {
        println(it)
    }

//    _list.sortBy {  }

    _list.let {  }
}