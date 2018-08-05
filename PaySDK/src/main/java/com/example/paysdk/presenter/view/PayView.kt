package com.example.paysdk.presenter.view

import com.example.baselibrary.presenter.view.BaseView

/**
 * Created by mac on 2018/7/23.
 *
 * 支付视图回调
 */
interface PayView : BaseView {

    //获取支付签名
    fun onGetSignResult(result: String)
    //同步支付成功状态
    fun onPayOrderResult(result: Boolean)

}