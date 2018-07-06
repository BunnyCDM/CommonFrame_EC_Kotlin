package com.example.usercenter.data.protocol

/**
 * Created by mac on 2018/6/14.
 *
 * 注册请求体
 * data:代表数据类
 */
data class RegisterReq(val mobile: String, val pwd: String, val verifyCode: String)