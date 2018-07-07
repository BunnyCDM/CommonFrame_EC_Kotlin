package com.example.usercenter.presenter.view

import com.example.baselibrary.presenter.view.BaseView
import com.example.usercenter.data.protocol.UserInfo

/**
 * Created by mac on 2018/6/14.
 *
 * 编辑用户资料，视图回调
 */
interface UserInfoView : BaseView {

    //获取上传凭证回调
    fun onGetUploadTokenResult(result: String)

    //编辑用户资料回调
    fun onEditUserResult(result: UserInfo)

}