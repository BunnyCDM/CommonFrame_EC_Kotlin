package com.example.paysdk.data.protocol

/**
 * Created by mac on 2018/7/23.
 *
 * 获取支付宝，支付签名
 */
data class GetPaySignReq(val orderId: Int, val totalPrice: Long)