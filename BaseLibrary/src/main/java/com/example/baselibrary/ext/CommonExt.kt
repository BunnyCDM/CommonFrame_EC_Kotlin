package com.example.baselibrary.ext

import android.view.View
import com.example.baselibrary.data.protocol.BaseResp
import com.example.baselibrary.rx.BaseFunc
import com.example.baselibrary.rx.BaseFuncBoolean
import rx.Observable

/**
 * Created by mac on 2018/6/14.
 *
 * Kotlin通用扩展
 */


//fun <T> Observable<T>.execute(subscribe: BaseSubscriber<T>,
//                              lifecycleProvider: LifecycleProvider<*>) {
//    this.subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .compose(lifecycleProvider.bindToLifecycle())
//            .subscribe(subscribe)
//}


fun View.OnClick(listener: View.OnClickListener) {
    this.setOnClickListener(listener)
}

fun View.OnClick(method: () -> Unit) { //函数是可以作为参数哦传递的
    this.setOnClickListener { method() }
}

fun <T> Observable<BaseResp<T>>.convert(): Observable<T> {
    return this.flatMap(BaseFunc())
}

fun <T> Observable<BaseResp<T>>.convertBoolean(): Observable<Boolean> {
    return this.flatMap(BaseFuncBoolean())
}

