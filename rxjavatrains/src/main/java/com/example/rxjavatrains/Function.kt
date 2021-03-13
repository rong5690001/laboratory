package com.example.rxjavatrains

interface Function<T, R> {
    fun apply(t: T): R
}