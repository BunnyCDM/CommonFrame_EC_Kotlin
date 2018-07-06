package com.example.usercenter.service

import rx.Observable

/**
 * Created by mac on 2018/6/14.
 *
 * 用户模块 业务接口
 */
interface UserService {

    //用户注册
    fun register(mobile: String, pwd: String, verifyCode: String): Observable<Boolean>

}