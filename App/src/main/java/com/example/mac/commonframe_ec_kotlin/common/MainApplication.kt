package com.example.mac.commonframe_ec_kotlin.common

import android.support.multidex.MultiDex
import cn.jpush.android.api.JPushInterface
import com.example.baselibrary.common.BaseApplication

/**
 * Created by mac on 2018/6/15.
 *
 * 主工程 Application
 */
class MainApplication : BaseApplication() {
    override fun onCreate() {
        super.onCreate()

        //极光推送初始化
        JPushInterface.setDebugMode(true)
        JPushInterface.init(this)

        MultiDex.install(this)
    }
}