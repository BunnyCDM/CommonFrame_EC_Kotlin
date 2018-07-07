package com.example.usercenter.presenter

import com.example.baselibrary.ext.execute
import com.example.baselibrary.presenter.BasePresenter
import com.example.baselibrary.rx.BaseSubscriber
import com.example.usercenter.presenter.view.ResetPwdView
import com.example.usercenter.service.UserService
import javax.inject.Inject

/**
 * Created by mac on 2018/6/14.
 *
 * 忘记密码Presenter
 */
class ResetPwdPresenter @Inject constructor() : BasePresenter<ResetPwdView>() {

    @Inject
    lateinit var userService: UserService

    //重置密码
    fun resetPwd(mobile: String, pwd: String) {
        if (!checkNetWork()) {
            return
        }

        mView.showLoading()

        userService.resetPwd(mobile, pwd).execute(object : BaseSubscriber<Boolean>(mView) {
            override fun onNext(t: Boolean) {
                if (t) {
                    mView.onResetPwdResult("重置密码成功")
                }
            }
        }, lifecycleProvider)
    }
}