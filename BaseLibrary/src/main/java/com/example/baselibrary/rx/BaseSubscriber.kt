package com.example.baselibrary.rx

import rx.Subscriber

/**
 * Created by mac on 2018/6/14.
 *
 * Rx订阅者默认实现
 */
open class BaseSubscriber<T>:Subscriber<T>() {


    override fun onError(e: Throwable?) {
    }

    override fun onCompleted() {
    }


    override fun onNext(t: T) {
    }


}