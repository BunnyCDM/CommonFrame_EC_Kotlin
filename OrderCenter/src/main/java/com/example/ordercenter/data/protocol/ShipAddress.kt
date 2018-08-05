package com.example.ordercenter.data.protocol

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by mac on 2018/7/17.
 *
 * 收货地址
 */
//@Parcelize
//data class ShipAddress(
//        val id: Int,
//        var shipUserName: String,
//        var shipUserMobile: String,
//        var shipAddress: String,
//        var shipIsDefault: Int
//) : Parcelable

data class ShipAddress(
        val id: Int,
        var shipUserName: String,
        var shipUserMobile: String,
        var shipAddress: String,
        var shipIsDefault: Int
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readInt(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readInt()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(id)
        writeString(shipUserName)
        writeString(shipUserMobile)
        writeString(shipAddress)
        writeInt(shipIsDefault)
    }

    companion object {

        @JvmField
        val CATEGORY: Parcelable.Creator<ShipAddress> = object : Parcelable.Creator<ShipAddress> {
            override fun createFromParcel(source: Parcel): ShipAddress = ShipAddress(source)

            override fun newArray(size: Int): Array<ShipAddress?> = arrayOfNulls(size)
        }
    }
}