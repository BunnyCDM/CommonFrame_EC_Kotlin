package com.example.goodscenter.injection.component

import com.example.baselibrary.injection.PerComponentScope
import com.example.baselibrary.injection.component.ActivityComponent
import com.example.goodscenter.injection.module.CartModule
import com.example.goodscenter.ui.fragment.CartFragment
import dagger.Component

/**
 * Created by mac on 2018/6/15.
 *
 * 购物车Component
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(CartModule::class))
interface CartComponent {
    fun inject(fragment: CartFragment)
}