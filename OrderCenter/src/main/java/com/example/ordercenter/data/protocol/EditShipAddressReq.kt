package com.example.ordercenter.data.protocol

/**
 * Created by mac on 2018/7/17.
 *
 * 修改收获地址
 */
data class EditShipAddressReq(val id:Int,val shipUserName:String,val shipUserMobile:String,val shipAddress:String,val shipIsDefault:Int)