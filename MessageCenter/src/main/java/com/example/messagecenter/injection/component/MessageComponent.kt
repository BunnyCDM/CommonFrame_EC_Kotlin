package com.example.messagecenter.injection.component

import com.example.baselibrary.injection.PerComponentScope
import com.example.baselibrary.injection.component.ActivityComponent
import com.example.messagecenter.injection.module.MessageModule
import com.example.messagecenter.ui.fragment.MessageFragment
import dagger.Component

/**
 * Created by mac on 2018/7/19.
 *
 * 消息模块注入组件
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),
        modules = arrayOf(MessageModule::class))
interface MessageComponent{
    fun inject(fragment: MessageFragment)
}