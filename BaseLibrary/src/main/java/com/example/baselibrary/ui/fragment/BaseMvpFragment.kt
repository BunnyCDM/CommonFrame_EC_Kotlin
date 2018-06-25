package com.example.baselibrary.ui.fragment

import android.os.Bundle
import android.text.AutoText
import com.example.baselibrary.common.BaseApplication
import com.example.baselibrary.injection.component.ActivityComponent
import com.example.baselibrary.injection.component.DaggerActivityComponent
import com.example.baselibrary.injection.module.ActivityModule
import com.example.baselibrary.presenter.BasePresenter
import com.example.baselibrary.presenter.view.BaseView
import org.jetbrains.anko.support.v4.toast
import javax.inject.Inject

/**
 * Created by mac on 2018/6/14.
 *
 * Fragment基类，业务无关
 */
open abstract class BaseMvpFragment<T : BasePresenter<*>> : BaseFragment(), BaseView {


    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError(text: String) {
        toast(text)
    }

    //lateinit var mPresenter:T

    @Inject
    lateinit var mPresenter: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivityInjection()

        injectComponent()
    }

    abstract fun injectComponent()


    lateinit var activityComponent: ActivityComponent

    private fun initActivityInjection() {
        activityComponent = DaggerActivityComponent.builder()
                .appComponent((activity.application as BaseApplication).appComponent)
                .activityModule(ActivityModule(activity))
                .build()
    }
}