package com.example.ordercenter.injection.module

import com.example.ordercenter.service.OrderService
import com.example.ordercenter.service.impl.OrderServiceImpl
import dagger.Module
import dagger.Provides

/**
 * Created by mac on 2018/7/17.
 *
 * 订单Module
 */
@Module
class OrderModule {

    @Provides
    fun provideOrderservice(orderService: OrderServiceImpl): OrderService {
        return orderService
    }

}