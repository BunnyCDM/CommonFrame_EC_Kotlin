package com.example.ordercenter.data.protocol

/**
 * Created by mac on 2018/7/17.
 *
 * 添加收货地址
 */
data class AddShipAddressReq(val shipUserName: String, val shipUserMobile: String, val shipAddress: String)