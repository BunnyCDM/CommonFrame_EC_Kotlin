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

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun context(): Context
}