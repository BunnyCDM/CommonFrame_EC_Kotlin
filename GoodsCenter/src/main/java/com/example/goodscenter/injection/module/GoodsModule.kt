package com.example.goodscenter.injection.module

import com.example.goodscenter.service.GoodsService
import com.example.goodscenter.service.impl.GoodsServiceImpl
import dagger.Module
import dagger.Provides

/**
 * Created by mac on 2018/6/15.
 *
 * GoodsModule
 */
@Module
class GoodsModule {

    @Provides
    fun provideGoodservice(goodsService: GoodsServiceImpl): GoodsService {
        return goodsService
    }

}