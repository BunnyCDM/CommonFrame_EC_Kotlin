package com.example.baselibrary.injection.module

import android.content.Context
import com.example.baselibrary.common.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by mac on 2018/6/14.
 *
 * Application级别Module
 */

@Module
class AppModule(private val context: BaseApplication) {

    @Provides
    @Singleton
    fun providesContext(): Context {
        return context
    }

}