package com.example.usercenter.presenter

import android.widget.Toast
import com.example.baselibrary.ext.execute
import com.example.baselibrary.presenter.BasePresenter
import com.example.baselibrary.rx.BaseSubscriber
import com.example.baselibrary.utils.NetWorkUtils
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

    @Inject
    lateinit var userService: UserService

//    @Inject
//    @field:[Named("service")] //这点和java中有点不一样
//    lateinit var userService: UserService
//
//    @Inject
//    @field:[Named("service2")] //这点和java中有点不一样
//    lateinit var userService2: UserService

    fun register(mobile: String, verifyCode: String, pwd: String) {
        /**
         * 业务逻辑
         */

        if(!checkNetWork()){
            println("网络不可用")
            return
        }
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


    }


    fun register2(mobile: String, pwd: String) {

        /**
         * 业务逻辑
         */

        //        val userService = UserServiceImpl()
        userService.register(mobile, "", pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : BaseSubscriber<Boolean>() {

                    override fun onNext(t: Boolean) {
                        super.onNext(t)
                    }

                })

    }

    fun register3(mobile: String, verifyCode: String, pwd: String) {

        /**
         * 业务逻辑
         */

        //        val userService = UserServiceImpl()
        userService.register(mobile, verifyCode, pwd)
                .execute(object : BaseSubscriber<Boolean>(mView) {
                    override fun onNext(t: Boolean) {
                        mView.onRegisterResult(t)
                    }
                })

    }

    fun register4(mobile: String, verifyCode: String, pwd: String) {

        /**
         * 业务逻辑
         */

        userService.register(mobile, verifyCode, pwd)
                .execute(object : BaseSubscriber<Boolean>(mView) {
                    override fun onNext(t: Boolean) {
                        mView.onRegisterResult(t)
                    }
                })

    }

}