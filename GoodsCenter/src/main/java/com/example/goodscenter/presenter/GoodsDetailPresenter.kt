package com.example.goodscenter.presenter

import com.example.baselibrary.ext.execute
import com.example.baselibrary.presenter.BasePresenter
import com.example.baselibrary.rx.BaseSubscriber
import com.example.baselibrary.utils.AppPrefsUtils
import com.example.goodscenter.common.GoodsConstant
import com.example.goodscenter.data.protocol.Goods
import com.example.goodscenter.presenter.view.GoodsDetailView
import com.example.goodscenter.service.CartService
import com.example.goodscenter.service.GoodsService
import javax.inject.Inject

/**
 * Created by mac on 2018/6/15.
 *
 * 商品详情 Presenter
 */
class GoodsDetailPresenter @Inject constructor() : BasePresenter<GoodsDetailView>() {

    @Inject
    lateinit var goodsService: GoodsService

    @Inject
    lateinit var cartService: CartService

    /*
        获取商品详情
     */
    fun getGoodsDetailList(goodsId: Int) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        goodsService.getGoodsDetail(goodsId).execute(object : BaseSubscriber<Goods>(mView) {
            override fun onNext(t: Goods) {
                mView.onGetGoodsDetailResult(t)
            }
        }, lifecycleProvider)

    }

    /*
        加入购物车
     */
    fun addCart(goodsId: Int, goodsDesc: String, goodsIcon: String, goodsPrice: Long,
                goodsCount: Int, goodsSku: String) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        cartService.addCart(goodsId,goodsDesc,goodsIcon,goodsPrice,
                goodsCount,goodsSku).execute(object : BaseSubscriber<Int>(mView) {
            override fun onNext(t: Int) {
                AppPrefsUtils.putInt(GoodsConstant.SP_CART_SIZE,t)
                mView.onAddCartResult(t)
            }
        }, lifecycleProvider)

    }

}