package com.example.paysdk.injection.component

import com.example.baselibrary.injection.PerComponentScope
import com.example.baselibrary.injection.component.ActivityComponent
import com.example.paysdk.injection.module.PayModule
import com.example.paysdk.ui.activity.CashRegisterActivity
import dagger.Component

/**
 * Created by mac on 2018/7/23.
 *
 * 支付Component
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(PayModule::class))
interface PayComponent {
    fun inject(activity: CashRegisterActivity)
}
