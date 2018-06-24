package com.example.baselibrary.presenter.view

import android.text.AutoText

/**
 * Created by mac on 2018/6/14.
 *
 * MVC中视图回调基类
 */
interface BaseView {
    fun showLoading()
    fun hideLoading()
    fun onError()
}