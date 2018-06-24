package com.example.usercenter.data.respoitory

import com.example.baselibrary.data.net.RetrofitFactory
import com.example.baselibrary.data.protocol.BaseResp
import com.example.usercenter.data.api.UserApi
import com.example.usercenter.data.protocol.RegisterReq
import rx.Observable
import javax.inject.Inject

/**
 * Created by mac on 2018/6/14.
 */
class UserRepository @Inject constructor() {

    fun register(mobile: String, pwd: String,verifyCode: String):Observable<BaseResp<String>>{
         return RetrofitFactory.instance.create(UserApi::class.java)
                .register(RegisterReq(mobile, pwd, verifyCode))
    }
}