package com.example.goodscenter.presenter.view

import com.example.baselibrary.presenter.view.BaseView
import com.example.goodscenter.data.protocol.Category

/**
 * Created by mac on 2018/6/15.
 *
 *  商品分类 视图回调
 */
interface CategoryView : BaseView {

    //获取商品分类列表
    fun onGetCategoryResult(result: MutableList<Category>?)
}