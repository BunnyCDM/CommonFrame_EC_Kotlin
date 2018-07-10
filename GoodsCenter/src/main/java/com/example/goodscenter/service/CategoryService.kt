package com.example.goodscenter.service

import com.example.goodscenter.data.protocol.Category
import rx.Observable

/**
 * Created by mac on 2018/6/15.
 *
 * 商品分类 业务层 接口
 */
interface CategoryService {

    // 获取分类
    fun getCategory(parentId: Int): Observable<MutableList<Category>?>
}