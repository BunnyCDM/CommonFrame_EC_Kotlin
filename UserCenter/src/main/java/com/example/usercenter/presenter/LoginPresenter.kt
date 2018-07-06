package com.example.usercenter.presenter

import com.example.baselibrary.ext.execute
import com.example.baselibrary.presenter.BasePresenter
import com.example.baselibrary.rx.BaseSubscriber
import com.example.usercenter.data.protocol.UserInfo
import com.example.usercenter.presenter.view.LoginView
import com.example.usercenter.service.UserService
import javax.inject.Inject

/**
 * Created by mac on 2018/6/14.
 *
 * 登录界面 presenter
 */
class LoginPresenter @Inject constructor() : BasePresenter<LoginView>() {

    @Inject
    lateinit var userService: UserService

    //登录
    fun login(mobile: String, pwd: String, pushId: String) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        userService.login(mobile, pwd, pushId).execute(object : BaseSubscriber<UserInfo>(mView) {
            override fun onNext(t: UserInfo) {
                mView.onLoginResult(t)
            }
        }, lifecycleProvider)


    }


}