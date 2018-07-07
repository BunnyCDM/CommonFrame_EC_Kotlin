package com.example.usercenter.injection.component

import com.example.baselibrary.injection.PerComponentScope
import com.example.baselibrary.injection.component.ActivityComponent
import com.example.usercenter.injection.module.UserModule
import com.example.usercenter.ui.activity.ForgetPwdActivity
import com.example.usercenter.ui.activity.LoginActivity
import com.example.usercenter.ui.activity.RegisterActivity
import com.example.usercenter.ui.activity.ResetPwdActivity
import dagger.Component

/**
 * Created by mac on 2018/6/14.
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class), modules = arrayOf(UserModule::class))
interface UserComponent {

    fun inject(activity: RegisterActivity)
    fun inject(activity: LoginActivity)
    fun inject(activity: ForgetPwdActivity)
    fun inject(activity: ResetPwdActivity)

}