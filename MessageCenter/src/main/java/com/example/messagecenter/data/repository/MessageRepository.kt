package com.example.messagecenter.data.repository

import com.example.baselibrary.data.net.RetrofitFactory
import com.example.baselibrary.data.protocol.BaseResp
import com.example.messagecenter.data.api.MessageApi
import com.example.messagecenter.data.protocol.Message
import rx.Observable
import javax.inject.Inject

/**
 * Created by mac on 2018/7/19.
 *
 * 消息数据层
 */
class MessageRepository @Inject constructor() {

    /*
        获取消息列表
     */
    fun getMessageList(): Observable<BaseResp<MutableList<Message>?>> {
        return RetrofitFactory.instance.create(MessageApi::class.java).getMessageList()
    }



}