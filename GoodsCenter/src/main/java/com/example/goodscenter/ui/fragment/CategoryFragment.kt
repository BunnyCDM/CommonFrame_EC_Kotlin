package com.example.goodscenter.ui.fragment

import com.example.baselibrary.ui.fragment.BaseMvpFragment
import com.example.goodscenter.data.protocol.Category
import com.example.goodscenter.presenter.CategoryPresenter
import com.example.goodscenter.presenter.view.CategoryView

/**
 * Created by mac on 2018/7/8.
 *
 * 商品分类 Fragment
 */
class CategoryFragment : BaseMvpFragment<CategoryPresenter>() ,CategoryView{
    override fun onGetCategoryResult(result: MutableList<Category>?) {
    }


    override fun injectComponent() {
    }
}