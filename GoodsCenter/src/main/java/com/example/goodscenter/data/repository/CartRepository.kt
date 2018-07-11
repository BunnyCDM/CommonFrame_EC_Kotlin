package com.example.goodscenter.data.repository

import com.example.baselibrary.data.net.RetrofitFactory
import com.example.baselibrary.data.protocol.BaseResp
import com.example.goodscenter.data.api.CartApi
import com.example.goodscenter.data.protocol.AddCartReq
import com.example.goodscenter.data.protocol.CartGoods
import com.example.goodscenter.data.protocol.DeleteCartReq
import com.example.goodscenter.data.protocol.SubmitCartReq
import rx.Observable
import javax.inject.Inject

/**
 * Created by mac on 2018/6/15.
 *
 * 购物车数据层
 */
class CartRepository @Inject constructor() {

    /*
        获取购物车列表
     */
    fun getCartList(): Observable<BaseResp<MutableList<CartGoods>?>> {
        return RetrofitFactory.instance.create(CartApi::class.java).getCartList()
    }

    /*
        添加商品到购物车
     */
    fun addCart(goodsId: Int, goodsDesc: String, goodsIcon: String, goodsPrice: Long,
                goodsCount: Int, goodsSku: String): Observable<BaseResp<Int>> {
        return RetrofitFactory.instance.create(CartApi::class.java)
                .addCart(AddCartReq(goodsId, goodsDesc, goodsIcon, goodsPrice, goodsCount, goodsSku))
    }

    /*
        删除购物车商品
     */
    fun deleteCartList(list: List<Int>): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(CartApi::class.java).deleteCartList(DeleteCartReq(list))
    }

    /*
        购物车结算
     */
    fun submitCart(list: MutableList<CartGoods>, totalPrice: Long): Observable<BaseResp<Int>> {
        return RetrofitFactory.instance.create(CartApi::class.java).submitCart(SubmitCartReq(list, totalPrice))
    }


}