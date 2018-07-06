package com.example.baselibrary.presenter

import android.content.Context
import com.example.baselibrary.presenter.view.BaseView
import com.example.baselibrary.utils.NetWorkUtils
import com.trello.rxlifecycle.LifecycleProvider
import javax.inject.Inject

/**
 * Created by mac on 2018/6/14.
 *
 * MVP中层基类(它会持有一个BaseView的引用，而BaseView仅处理回调使用)
 */
open class BasePresenter<T : BaseView> {

    lateinit var mView: T

    //Dagger注入，Rx生命周期管理
    @Inject
    lateinit var lifecycleProvider: LifecycleProvider<*>

    @Inject
    lateinit var context: Context

    //检查网络是否可用
    fun checkNetWork(): Boolean {
        if (NetWorkUtils.isNetWorkAvailable(context)) {
            return true
        } else {
            mView.onError("网络不可用")
            return false
        }

    }

}