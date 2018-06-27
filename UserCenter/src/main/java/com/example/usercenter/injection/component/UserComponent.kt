package com.example.usercenter.injection.component

import com.example.usercenter.injection.module.UserModule
import com.example.usercenter.ui.activity.RegisterActivity
import dagger.Component

/**
 * Created by mac on 2018/6/14.
 */

@Component(modules = arrayOf(UserModule::class))
interface UserComponent {

    fun inject(activity: RegisterActivity)

}