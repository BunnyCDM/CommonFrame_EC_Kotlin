package com.example.goodscenter.injection.component

import com.example.baselibrary.injection.PerComponentScope
import com.example.baselibrary.injection.component.ActivityComponent
import com.example.goodscenter.injection.module.CartModule
import com.example.goodscenter.injection.module.GoodsModule
import com.example.goodscenter.ui.activity.GoodsActivity
import com.example.goodscenter.ui.fragment.GoodsDetailTabOneFragment
import dagger.Component

/**
 * Created by mac on 2018/6/15.
 *
 * 商品Component
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class), modules = arrayOf(GoodsModule::class, CartModule::class))
interface GoodsComponent {
    fun inject(activity: GoodsActivity)
    fun inject(fragment: GoodsDetailTabOneFragment)
}