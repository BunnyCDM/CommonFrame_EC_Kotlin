package com.example.usercenter.data.protocol

/**
 * Created by mac on 2018/6/14.
 *
 * 登录请求体
 */
data class LoginReq(val mobile: String, val pwd: String, val pushId: String)