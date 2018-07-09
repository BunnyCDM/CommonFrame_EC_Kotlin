package com.example.goodscenter.ui.fragment

import com.example.baselibrary.ui.fragment.BaseMvpFragment
import com.example.goodscenter.presenter.CartListPresenter
import com.example.goodscenter.presenter.view.CartListView

/**
 * Created by mac on 2018/7/8.
 */
class CartFragment : BaseMvpFragment<CartListPresenter>(), CartListView {


    override fun injectComponent() {
    }
}