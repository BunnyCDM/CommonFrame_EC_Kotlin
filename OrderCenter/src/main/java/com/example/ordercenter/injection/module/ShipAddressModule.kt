package com.example.ordercenter.injection.module

import com.example.ordercenter.service.ShipAddressService
import com.example.ordercenter.service.impl.ShipAddressServiceImpl
import dagger.Module
import dagger.Provides

/**
 * Created by mac on 2018/7/18.
 *
 * 收货人信息Module
 */
@Module
class ShipAddressModule {

    @Provides
    fun provideShipAddressservice(shipAddressService: ShipAddressServiceImpl): ShipAddressService {
        return shipAddressService
    }

}