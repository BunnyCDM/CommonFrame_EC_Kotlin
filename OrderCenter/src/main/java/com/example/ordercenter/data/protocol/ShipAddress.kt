package com.example.ordercenter.data.protocol

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by mac on 2018/7/17.
 *
 * 收货地址
 */
@Parcelize
data class ShipAddress(
        val id: Int,
        var shipUserName: String,
        var shipUserMobile: String,
        var shipAddress: String,
        var shipIsDefault: Int
) : Parcelable