package com.example.usercenter.presenter.view

import com.example.baselibrary.presenter.view.BaseView
import com.example.usercenter.data.protocol.UserInfo

/**
 * Created by mac on 2018/6/14.
 *
 * 用户登录，视图回调
 */
interface LoginView : BaseView {
    fun onLoginResult(result: UserInfo)
}