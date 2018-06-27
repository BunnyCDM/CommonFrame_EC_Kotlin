package com.example.baselibrary.injection.module

import android.app.Activity
import dagger.Module
import dagger.Provides

/**
 * Created by mac on 2018/6/14.
 *
 * Activity级别Module
 */

@Module
class ActivityModule(private val activity: Activity) {

    @Provides
    fun providesActivity(): Activity {
        return activity
    }

}
