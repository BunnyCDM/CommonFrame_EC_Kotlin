package com.example.baselibrary.ui.activity

import android.os.Bundle
import com.example.baselibrary.common.BaseApplication
import com.example.baselibrary.injection.component.ActivityComponent
import com.example.baselibrary.injection.component.DaggerActivityComponent
import com.example.baselibrary.injection.module.ActivityModule
import com.example.baselibrary.injection.module.LifecycleProviderModule
import com.example.baselibrary.presenter.BasePresenter
import com.example.baselibrary.presenter.view.BaseView
import javax.inject.Inject

/**
 * Created by mac on 2018/6/14.
 *
 * Activity基类，业务相关
 */
open abstract class BaseMvpActivity<T:BasePresenter<*>>:BaseActivity(),BaseView {


    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    //lateinit var mPresenter:T

    @Inject
    lateinit var mPresenter:T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivityInjection()

        injectComponent()
    }

    abstract fun injectComponent()


    lateinit var activityComponent: ActivityComponent

    private fun initActivityInjection(){
        activityComponent=DaggerActivityComponent.builder()
                .appComponent((application as BaseApplication).appComponent)
                .activityModule(ActivityModule(this))
                .build()
    }
}