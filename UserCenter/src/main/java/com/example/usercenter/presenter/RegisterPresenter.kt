package com.example.usercenter.presenter

import com.example.baselibrary.ext.execute
import com.example.baselibrary.presenter.BasePresenter
import com.example.baselibrary.rx.BaseSubscriber
import com.example.usercenter.presenter.view.RegisterView
import com.example.usercenter.service.UserService
import com.example.usercenter.service.impl.UserServiceImpl
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by mac on 2018/6/14.
 */
class RegisterPresenter @Inject constructor() : BasePresenter<RegisterView>() {

    @Inject
    @field:[Named("service")] // @Named("service")
    lateinit var userService: UserService

    fun register1(mobile: String, verifyCode: String, pwd: String) {
        mView.onRegisterResult("注册成功")
    }

    fun register2(mobile: String, verifyCode: String, pwd: String) {
        /**
         * 业务逻辑
         */
        //mView.showLoading()

        //val userService = UserServiceImpl() //（上面已经采用依赖注入，所以就不需要了）
        userService.register1(mobile, verifyCode, pwd)
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


    fun register3(mobile: String, verifyCode: String, pwd: String) {

        val userService = UserServiceImpl()
        userService.register1(mobile, verifyCode, pwd)
                .execute(object : BaseSubscriber<Boolean>(mView) {
                    override fun onNext(t: Boolean) {
                        mView.onRegisterResult("注册成功")
                    }
                })
    }

    @Inject
    @field:[Named("service2")] // @Named("service2")
    lateinit var userService2: UserService
    fun register2_2(mobile: String, verifyCode: String, pwd: String) {

        userService2.register1(mobile, verifyCode, pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Subscriber<Boolean>() {
                    override fun onNext(t: Boolean?) {
                        if (t != null) {
                            mView.onRegisterResult("注册失败")
                        }
                    }

                    override fun onError(e: Throwable?) {
                    }

                    override fun onCompleted() {
                    }

                })

    }

}