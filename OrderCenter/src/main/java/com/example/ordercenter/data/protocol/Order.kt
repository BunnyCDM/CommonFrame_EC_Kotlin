package com.example.ordercenter.data.protocol

/**
 * Created by mac on 2018/7/17.
 *
 * 订单数据类
 */
data class Order(
        val id: Int,
        val payType: Int,
        var shipAddress: ShipAddress?,
        val totalPrice: Long,
        var orderStatus: Int,
        val orderGoodsList: MutableList<OrderGoods>
)