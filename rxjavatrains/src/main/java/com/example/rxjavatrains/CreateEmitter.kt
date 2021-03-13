package com.example.rxjavatrains

class CreateEmitter<T>(val observer: Observer<T>):Emitter<T> {

    override fun onNext(value: T) {
        observer.onNext(value)
    }

    override fun onError(error: Throwable) {
        observer.onError(error)
    }

    override fun onCompleted() {
        observer.onComplete()
    }
}