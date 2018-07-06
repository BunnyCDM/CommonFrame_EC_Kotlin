package com.example.usercenter.presenter.view

import com.example.baselibrary.presenter.view.BaseView

/**
 * Created by mac on 2018/6/14.
 *
 * 用户注册 视图回调
 */
interface RegisterView : BaseView {
    fun onRegisterResult(result: String)//fun onRegisterResult(result:Boolean)
}