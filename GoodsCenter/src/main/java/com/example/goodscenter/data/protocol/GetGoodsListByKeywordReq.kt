package com.example.goodscenter.data.protocol

/**
 * Created by mac on 2018/6/15.
 *
 * 按关键字搜索商品
 */
data class GetGoodsListByKeywordReq(val keyword: String,
                                    val pageNo: Int)