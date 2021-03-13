//package com.example.rxjavatrains
//
///**
// * observed
// */
//abstract class Observable<T> {
//
//    companion object {
//        fun <T> create(source: ObservableOnSubscribe<T>): Observable<T> = ObservableCreate(source)
//    }
//
//    abstract fun subscribe(observer: Observer<T>)
//
//    fun <R> map(action: Function<in T, out R>): Observable<R> {
//        return
//    }
//}