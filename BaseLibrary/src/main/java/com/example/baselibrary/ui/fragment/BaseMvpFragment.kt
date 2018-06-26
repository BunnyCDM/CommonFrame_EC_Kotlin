package com.example.baselibrary.ui.fragment

import android.os.Bundle
import com.example.baselibrary.presenter.BasePresenter
import com.example.baselibrary.presenter.view.BaseView
import org.jetbrains.anko.support.v4.toast

/**
 * Created by mac on 2018/6/14.
 *
 * Fragment基类，业务无关
 */
open abstract class BaseMvpFragment<T : BasePresenter<*>> : BaseFragment(), BaseView {


    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun onError(text: String) {
        toast(text)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivityInjection()

        injectComponent()
    }

    abstract fun injectComponent()


    private fun initActivityInjection() {

    }
}