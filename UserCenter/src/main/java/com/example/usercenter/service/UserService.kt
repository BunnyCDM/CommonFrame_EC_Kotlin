package com.example.usercenter.service

import rx.Observable

/**
 * Created by mac on 2018/6/14.
 */
interface UserService {

    fun register1(mobile: String, pwd: String,verifyCode: String): Observable<Boolean>

    fun register2(mobile: String, pwd: String,verifyCode: String): Observable<String>

}