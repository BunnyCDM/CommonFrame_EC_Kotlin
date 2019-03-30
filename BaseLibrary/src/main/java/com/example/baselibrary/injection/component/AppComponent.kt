package com.example.baselibrary.injection.component

import android.content.Context
import com.example.baselibrary.injection.module.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by mac on 2018/6/14.
 *
 * Application级别Component
 */

@Singleton //并没有什么实际的能力，只是告诉AppComponent是单例
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun context(): Context
}