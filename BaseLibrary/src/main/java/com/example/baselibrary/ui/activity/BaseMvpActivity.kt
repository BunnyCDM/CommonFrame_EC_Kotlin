package com.example.baselibrary.ui.activity

import android.os.Bundle
import com.example.baselibrary.common.BaseApplication
import com.example.baselibrary.injection.component.ActivityComponent
import com.example.baselibrary.injection.component.DaggerActivityComponent
import com.example.baselibrary.injection.module.ActivityModule
import com.example.baselibrary.injection.module.LifecycleProviderModule
import com.example.baselibrary.presenter.BasePresenter
import com.example.baselibrary.presenter.view.BaseView
import com.example.baselibrary.widgets.ProgressLoading
import javax.inject.Inject

/**
 * Created by mac on 2018/6/14.
 *
 * Activity基类，业务相关
 */
open abstract class BaseMvpActivity<T:BasePresenter<*>>:BaseActivity(),BaseView {

    private lateinit var mLoadingDialog:ProgressLoading

    override fun showLoading() {
        mLoadingDialog.showLoading()
    }

    override fun hideLoading() {
        mLoadingDialog.hideLoading()
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

        mLoadingDialog=ProgressLoading.create(this)
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