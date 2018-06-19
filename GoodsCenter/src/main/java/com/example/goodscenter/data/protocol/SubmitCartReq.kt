package com.example.goodscenter.data.protocol

/**
 * Created by mac on 2018/6/15.
 *
 * 提交购物车
 */
data class SubmitCartReq (val goodsList: List<CartGoods>,val totalPrice: Long)