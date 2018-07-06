package com.example.usercenter.data.api

import com.example.baselibrary.data.protocol.BaseResp
import com.example.usercenter.data.protocol.LoginReq
import com.example.usercenter.data.protocol.RegisterReq
import com.example.usercenter.data.protocol.UserInfo
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

/**
 * Created by mac on 2018/6/14.
 *
 * 用户相关接口
 */
interface UserApi {

    //用户注册
    @POST("userCenter/register")
    fun register(@Body req: RegisterReq): Observable<BaseResp<String>>


    //用户登录
    @POST("userCenter/login")
    fun login(@Body req: LoginReq): Observable<BaseResp<UserInfo>>

}