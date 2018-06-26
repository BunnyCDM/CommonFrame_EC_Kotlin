package com.example.baselibrary.ext

import android.view.View
import com.example.baselibrary.data.protocol.BaseResp
import com.example.baselibrary.rx.BaseFunc
import com.example.baselibrary.rx.BaseFuncBoolean
import com.example.baselibrary.rx.BaseSubscriber
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by mac on 2018/6/14.
 *
 * Kotlin通用扩展
 */


fun <T> Observable<T>.execute(subscribe: BaseSubscriber<T>) {
    this.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(subscribe)
}


fun View.OnClick(listener: View.OnClickListener) {
    this.setOnClickListener(listener)
}

fun View.OnClick(method: () -> Unit) { //函数是可以作为参数传递的
    this.setOnClickListener { method() }
}

fun <T> Observable<BaseResp<T>>.convert(): Observable<T> {
    return this.flatMap(BaseFunc())
}

fun <T> Observable<BaseResp<T>>.convertBoolean(): Observable<Boolean> {
    return this.flatMap(BaseFuncBoolean())
}

