package com.example.usercenter.presenter.view

import com.example.baselibrary.presenter.view.BaseView

/**
 * Created by mac on 2018/6/14.
 *
 * 忘记密码，视图回调
 */
interface ForgetPwdView : BaseView {

    //忘记密码回调
    fun onForgetPwdResult(result: String)

}