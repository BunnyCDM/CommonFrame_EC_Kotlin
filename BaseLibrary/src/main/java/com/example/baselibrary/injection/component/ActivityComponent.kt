package com.example.baselibrary.injection.component

import android.app.Activity
import com.example.baselibrary.injection.ActivityScope
import com.example.baselibrary.injection.module.ActivityModule
import dagger.Component

/**
 * Created by mac on 2018/6/14.
 *
 * Activity级别Component
 */

@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class), modules =
arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun activity(): Activity
//    fun context(): Context
//    fun lifecycleProvider(): LifecycleProvider<*>
}