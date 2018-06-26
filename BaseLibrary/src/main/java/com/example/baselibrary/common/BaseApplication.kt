package com.example.baselibrary.common

import android.app.Application

/**
 * Created by mac on 2018/6/14.
 *
 * Application 基类
 */
class BaseApplication : Application() {


    override fun onCreate() {
        super.onCreate()

        initAppInjection()

    }

    private fun initAppInjection() {

    }


}