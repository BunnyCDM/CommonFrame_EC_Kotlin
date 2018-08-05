package com.example.paysdk.injection.module

import com.example.paysdk.service.PayService
import com.example.paysdk.service.impl.PayServiceImpl
import dagger.Module
import dagger.Provides

/**
 * Created by mac on 2018/7/23.
 *
 * 支付Module
 */
@Module
class PayModule {

    @Provides
    fun providePayService(payService: PayServiceImpl): PayService {
        return payService
    }

}