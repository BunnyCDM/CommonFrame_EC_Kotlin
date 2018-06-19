package com.example.goodscenter.data.protocol

/**
 * Created by mac on 2018/6/15.
 *
 * 删除购物车商品请求
 */
data class DeleteCartReq (val cartIdList: List<Int> = arrayListOf())