package com.example.baselibrary.rx

import com.example.baselibrary.data.protocol.BaseResp
import rx.Observable
import rx.functions.Func1

/**
 * Created by mac on 2018/6/14.
 *
 * Boolean类型转化封装
 */
class BaseFuncBoolean<T> : Func1<BaseResp<T>, Observable<Boolean>> {

    override fun call(t: BaseResp<T>): Observable<Boolean> {
        if (t.status != 0) {
            return Observable.error(BaseException(t.status, t.message))
        }
        return Observable.just(true)
    }
}