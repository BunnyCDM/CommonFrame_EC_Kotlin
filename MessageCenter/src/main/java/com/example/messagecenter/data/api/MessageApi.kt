package com.example.messagecenter.data.api

import com.example.baselibrary.data.protocol.BaseResp
import com.example.messagecenter.data.protocol.Message
import retrofit2.http.POST
import rx.Observable

/**
 * Created by mac on 2018/7/19.
 *
 * 消息接口
 */
interface MessageApi {

    /*
        获取消息列表
     */
    @POST("msg/getList")
    fun getMessageList(): Observable<BaseResp<MutableList<Message>?>>

}