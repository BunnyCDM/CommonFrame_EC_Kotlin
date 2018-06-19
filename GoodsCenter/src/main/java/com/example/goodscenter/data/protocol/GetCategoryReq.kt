package com.example.goodscenter.data.protocol

/**
 * Created by mac on 2018/6/15.
 *
 *  获取分类列表请求，parentId为0是一级分类
 */
data class GetCategoryReq(val parentId: Int)