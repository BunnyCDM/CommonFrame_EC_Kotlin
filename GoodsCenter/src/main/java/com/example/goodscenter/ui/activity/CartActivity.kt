package com.example.goodscenter.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.goodscenter.R

/**
 * Created by mac on 2018/6/15.
 *
 * 购物车Activity只是Fragment一个壳
 */
class CartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
    }

}