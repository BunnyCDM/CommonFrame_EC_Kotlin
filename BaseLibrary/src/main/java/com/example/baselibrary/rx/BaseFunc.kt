package com.example.baselibrary.rx

import com.example.baselibrary.common.ResultCode
import com.example.baselibrary.data.protocol.BaseResp
import rx.Observable
import rx.functions.Func1

/**
 * Created by mac on 2018/6/14.
 *
 * 通用数据类型转换封装
 */
class BaseFunc<T> : Func1<BaseResp<T>, Observable<T>> {

    override fun call(t: BaseResp<T>): Observable<T> {
        if (t.status != ResultCode.SUCCESS) {
            return Observable.error(BaseException(t.status, t.message))
        }
        return Observable.just(t.data)
    }
}