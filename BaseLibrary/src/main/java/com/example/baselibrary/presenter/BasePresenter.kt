package com.example.baselibrary.presenter

import com.example.baselibrary.presenter.view.BaseView
import com.trello.rxlifecycle.LifecycleProvider
import javax.inject.Inject

/**
 * Created by mac on 2018/6/14.
 *
 * MVP中层基类(它会持有一个BaseView的引用，而BaseView仅处理回调使用)
 */
open class BasePresenter<T : BaseView> {

    lateinit var mView: T

    @Inject
    lateinit var lifecycleProvider: LifecycleProvider<*>

//    @Inject
//    lateinit var context: Context
//
//    fun checkNetWork(): Boolean {
//        if (NetWorkUtils.isNetWorkAvailable(context)) {
//
//            return true
//        } else {
//            mView.onError("网络不可用")
//            return false
//        }
//
//    }

}