package com.example.messagecenter.service

import com.example.messagecenter.data.protocol.Message
import rx.Observable

/**
 * Created by mac on 2018/7/19.
 *
 * 消息业务接口
 */
interface MessageService {
    //获取消息列表
    fun getMessageList(): Observable<MutableList<Message>?>

}