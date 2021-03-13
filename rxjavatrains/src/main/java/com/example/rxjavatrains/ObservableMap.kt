//package com.example.rxjavatrains
//
//class ObservableMap<T, R>(val source: Observable<T>, val mapper:Function<in T, out R>) : Observable<R>() {
//
//    override fun subscribe(observer: Observer<R>) {
//        source.subscribe(MapObserver(observer = observer, mapper = mapper))
//    }
//
//    inner class MapObserver<T, R>(val observer: Observer<R>, val mapper: Function<in T, out R>) : Observer<R>()  {
//
//        override fun onSubscribe(emitter: Emitter<R>) {
//            observer.onSubscribe(emitter = emitter)
//        }
//
//        override fun onNext(t: T) {
//            observer.onNext(mapper.apply(t))
//        }
//
//        override fun onError(e: Throwable) {
//
//        }
//
//        override fun onComplete() {
//
//        }
//    }
//
//
//}