package com.example.goodscenter.data.protocol

/**
 * Created by mac on 2018/6/15.
 *
 * 商品SKU数据类
 */
data class GoodsSku(
        val id: Int,
        val skuTitle: String,//SKU标题
        val skuContent: List<String>//SKU内容
)