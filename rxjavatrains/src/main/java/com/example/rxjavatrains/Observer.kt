package com.example.rxjavatrains

/**
 * observer
 */
abstract class Observer<T> {

    // After subscribing to the observer, this method will be called back;
    abstract fun onSubscribe(emitter: Emitter<T>)

    // Pass regular events, used to pass data
    abstract fun onNext(t: T)

    // Deliver error events
    abstract fun onError(e: Throwable)

    // Delivery complete event
    abstract fun onComplete()

}