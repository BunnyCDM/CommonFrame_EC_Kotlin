package com.example.messagecenter.presenter.view

import com.example.baselibrary.presenter.view.BaseView
import com.example.messagecenter.data.protocol.Message

/**
 * Created by mac on 2018/7/8.
 *
 * 消息列表，视图回调
 */
interface MessageView : BaseView {

    //获取消息列表回调
    fun onGetMessageResult(result:MutableList<Message>?)
}