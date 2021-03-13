//package com.example.rxjavatrains
//
//class ObservableCreate<T>(private val source: ObservableOnSubscribe<T>) : Observable<T>() {
//
//    override fun subscribe(observer: Observer<T>) {
//
//        val parent = CreateEmitter(observer)
//
//        observer.onSubscribe(parent)
//
//        source.subscribe(parent)
//    }
//}