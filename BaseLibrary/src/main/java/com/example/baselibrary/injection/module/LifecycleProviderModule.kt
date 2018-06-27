package com.example.baselibrary.injection.module

import com.trello.rxlifecycle.LifecycleProvider
import dagger.Module
import dagger.Provides

/**
 * Created by mac on 2018/6/14.
 *
 * Rx生命周期管理能用Module
 */
@Module
class LifecycleProviderModule(private val lifecycleProvider: LifecycleProvider<*>) {

    @Provides
    fun providersLifecycleProvider(): LifecycleProvider<*> {
        return lifecycleProvider
    }

}