package com.example.usercenter.data.respoitory

import com.example.baselibrary.data.net.RetrofitFactory
import com.example.baselibrary.data.protocol.BaseResp
import com.example.usercenter.data.api.UserApi
import com.example.usercenter.data.protocol.LoginReq
import com.example.usercenter.data.protocol.RegisterReq
import com.example.usercenter.data.protocol.UserInfo
import rx.Observable
import javax.inject.Inject

/**
 * Created by mac on 2018/6/14.
 *
 * 用户相关数据层
 */
class UserRepository @Inject constructor() {


    //用户注册
    fun register(mobile: String, pwd: String, verifyCode: String): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(UserApi::class.java).register(RegisterReq(mobile, pwd, verifyCode))
    }

    /*
     用户登录
  */
    fun login(mobile:String,pwd:String,pushId:String): Observable<BaseResp<UserInfo>>{
        return RetrofitFactory.instance.create(UserApi::class.java).login(LoginReq(mobile,pwd,pushId))
    }

}