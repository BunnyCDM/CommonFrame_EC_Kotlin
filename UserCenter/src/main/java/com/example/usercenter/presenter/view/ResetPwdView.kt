package com.example.usercenter.presenter.view

import com.example.baselibrary.presenter.view.BaseView

/**
 * Created by mac on 2018/6/14.
 *
 * 重置密码，视图回调
 */
interface ResetPwdView : BaseView {
    fun onResetPwdResult(result: String)
}