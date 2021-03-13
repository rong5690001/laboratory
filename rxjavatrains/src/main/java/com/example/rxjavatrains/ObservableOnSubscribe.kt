package com.example.rxjavatrains

interface ObservableOnSubscribe<T> {

    fun subscribe(emitter: Emitter<T>)

}