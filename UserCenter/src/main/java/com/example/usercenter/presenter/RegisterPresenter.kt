package com.example.usercenter.presenter

import com.example.baselibrary.presenter.BasePresenter
import com.example.usercenter.presenter.view.RegisterView
import com.example.usercenter.service.UserService
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by mac on 2018/6/14.
 */
class RegisterPresenter @Inject constructor() : BasePresenter<RegisterView>() {

    fun register1(mobile: String, verifyCode: String, pwd: String) {
        /**
         * 业务逻辑
         */
        mView.onRegisterResult("注册成功")
    }

    @Inject
    lateinit var userService: UserService

    fun register(mobile: String, verifyCode: String, pwd: String) {
        /**
         * 业务逻辑
         */
        //mView.showLoading()

        userService.register(mobile, verifyCode, pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Subscriber<Boolean>() {
                    override fun onNext(t: Boolean?) {
                        if (t != null) {
                            mView.onRegisterResult("注册成功")
                            //mView.hideLoading()
                        }
                    }

                    override fun onError(e: Throwable?) {
                    }

                    override fun onCompleted() {
                    }

                })


        /**
         * 业务逻辑
         */

        //val userService = UserServiceImpl()
//        userService.register(mobile, verifyCode, pwd)
//                .execute(object : BaseSubscriber<Boolean>(mView) {
//                    override fun onNext(t: Boolean) {
//                        mView.onRegisterResult("注册成功")
//                    }
//                })


    }


}