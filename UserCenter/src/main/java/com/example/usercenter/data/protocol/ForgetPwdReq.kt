package com.example.usercenter.data.protocol

/**
 * Created by mac on 2018/6/14.
 *
 * 忘记密码请求体
 */
data class ForgetPwdReq(val mobile: String, val verifyCode: String)