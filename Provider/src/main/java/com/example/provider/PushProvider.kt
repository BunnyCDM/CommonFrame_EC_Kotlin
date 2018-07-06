package com.example.provider

import com.alibaba.android.arouter.facade.template.IProvider

/**
 * Created by mac on 2018/6/14.
 *
 * 跨模块接口调用 接口定义
 */
interface PushProvider : IProvider {
    fun getPushId(): String
}