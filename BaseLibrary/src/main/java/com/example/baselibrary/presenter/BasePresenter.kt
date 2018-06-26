package com.example.baselibrary.presenter

import com.example.baselibrary.presenter.view.BaseView

/**
 * Created by mac on 2018/6/14.
 *
 * MVP中层基类(它会持有一个BaseView的引用，而BaseView仅处理回调使用)
 */
open class BasePresenter<T : BaseView> {

    lateinit var mView: T

}