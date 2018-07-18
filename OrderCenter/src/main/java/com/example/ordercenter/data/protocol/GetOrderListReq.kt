package com.example.ordercenter.data.protocol

/**
 * Created by mac on 2018/7/17.
 *
 * 根据订单状态查询订单列表
 */
data class GetOrderListReq(val orderStatus:Int)