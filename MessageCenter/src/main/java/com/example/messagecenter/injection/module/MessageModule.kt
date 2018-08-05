package com.example.messagecenter.injection.module

import com.example.messagecenter.service.MessageService
import com.example.messagecenter.service.impl.MessageServiceImpl
import dagger.Module
import dagger.Provides

/**
 * Created by mac on 2018/7/19.
 *
 * 消息模块业务注入
 */
@Module
class MessageModule {

    @Provides
    fun provideMessageService(messageService: MessageServiceImpl): MessageService {
        return  messageService
    }

}