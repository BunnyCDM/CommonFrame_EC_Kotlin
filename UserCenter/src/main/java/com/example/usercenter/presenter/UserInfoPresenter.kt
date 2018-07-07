package com.example.usercenter.presenter

import com.example.baselibrary.presenter.BasePresenter
import com.example.usercenter.presenter.view.UserInfoView
import com.example.usercenter.service.UserService
import javax.inject.Inject

/**
 * Created by mac on 2018/6/14.
 */
class UserInfoPresenter @Inject constructor() : BasePresenter<UserInfoView>() {

    @Inject
    lateinit var userService: UserService

    fun getUploadToken() {

    }

}