package com.example.baselibrary.rx

import com.example.baselibrary.presenter.view.BaseView
import rx.Subscriber

/**
 * Created by mac on 2018/6/14.
 *
 * Rx订阅者默认实现
 */
open class BaseSubscriber<T>(val baseView:BaseView):Subscriber<T>() {


    override fun onError(e: Throwable?) {
        baseView.hideLoading()
    }

    override fun onCompleted() {
        baseView.hideLoading()
    }


    override fun onNext(t: T) {
    }


}