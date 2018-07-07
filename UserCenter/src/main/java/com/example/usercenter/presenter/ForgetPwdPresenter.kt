package com.example.usercenter.presenter

import com.example.baselibrary.ext.execute
import com.example.baselibrary.presenter.BasePresenter
import com.example.baselibrary.rx.BaseSubscriber
import com.example.usercenter.presenter.view.ForgetPwdView
import com.example.usercenter.service.UserService
import javax.inject.Inject

/**
 * Created by mac on 2018/6/14.
 *
 * 忘记密码Presenter
 */

class ForgetPwdPresenter @Inject constructor() : BasePresenter<ForgetPwdView>() {

    @Inject
    lateinit var userService: UserService

    fun forgetPwd(mobile: String, verifyCode: String) {
        if (!checkNetWork()) {
            return
        }

        mView.showLoading()

        userService.forgetPwd(mobile, verifyCode).execute(object : BaseSubscriber<Boolean>(mView) {
            override fun onNext(t: Boolean) {
                if (t) {
                    mView.onForgetPwdResult("验证成功")
                }
            }
        }, lifecycleProvider)
    }
}