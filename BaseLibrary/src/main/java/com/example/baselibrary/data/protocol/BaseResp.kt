package com.example.baselibrary.data.protocol

/**
 * Created by mac on 2018/6/14.
 *
 * 能用响应对象
 * @status:响应状态码
 * @message:响应文字消息
 * @data:具体响应业务对象
 */
data class BaseResp<out T>(val status: Int, val message: String, val data: T)