package com.example.baselibrary.common

import android.app.Application
import com.example.baselibrary.injection.component.AppComponent
import com.example.baselibrary.injection.component.DaggerAppComponent
import com.example.baselibrary.injection.module.AppModule

/**
 * Created by mac on 2018/6/14.
 *
 * Application 基类
 */
class BaseApplication:Application() {

    lateinit var appComponent:AppComponent

    override fun onCreate() {
        super.onCreate()

        initAppInjection()
    }

    private fun initAppInjection(){
        appComponent=DaggerAppComponent.builder()
                .appModule(AppModule(this)).build()
    }

}