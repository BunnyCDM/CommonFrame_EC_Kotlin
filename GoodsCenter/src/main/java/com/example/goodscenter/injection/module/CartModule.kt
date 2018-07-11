package com.example.goodscenter.injection.module

import com.example.goodscenter.service.CartService
import com.example.goodscenter.service.impl.CartServiceImpl
import dagger.Module
import dagger.Provides

/**
 * Created by mac on 2018/6/15.
 *
 * 购物车Module
 */
@Module
class CartModule {

    @Provides
    fun provideCartservice(cartService: CartServiceImpl): CartService {
        return cartService
    }

}