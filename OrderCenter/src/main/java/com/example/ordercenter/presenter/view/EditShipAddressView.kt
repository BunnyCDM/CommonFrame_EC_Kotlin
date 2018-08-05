package com.example.ordercenter.presenter.view

import com.example.baselibrary.presenter.view.BaseView

/**
 * Created by mac on 2018/7/18.
 *
 * 编辑收货人信息 视图回调
 */
interface EditShipAddressView : BaseView {
    //添加收货人回调
    fun onAddShipAddressResult(result: Boolean)
    //修改收货人回调
    fun onEditShipAddressResult(result: Boolean)
}
