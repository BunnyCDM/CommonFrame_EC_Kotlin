package com.example.ordercenter.service

import com.example.ordercenter.data.protocol.ShipAddress
import rx.Observable

/**
 * Created by mac on 2018/7/18.
 *
 * 收货人业务信息接口
 */
interface ShipAddressService {

    /*
        添加收货地址
     */
    fun addShipAddress(shipUserName: String, shipUserMobile: String, shipAddress: String): Observable<Boolean>

    /*
    获取收货地址列表
 */
    fun getShipAddressList(): Observable<MutableList<ShipAddress>?>

    /*
     修改收货地址
  */
    fun editShipAddress(address: ShipAddress): Observable<Boolean>

    /*
    删除收货地址
 */
    fun deleteShipAddress(id: Int): Observable<Boolean>

}