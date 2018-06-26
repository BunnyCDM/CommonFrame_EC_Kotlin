package com.example.usercenter.data.api

import com.example.baselibrary.data.protocol.BaseResp
import com.example.usercenter.data.protocol.RegisterReq
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

/**
 * Created by mac on 2018/6/14.
 */
interface UserApi {

    @POST("userCenter/register")
    fun register(@Body req: RegisterReq): Observable<BaseResp<String>>

}