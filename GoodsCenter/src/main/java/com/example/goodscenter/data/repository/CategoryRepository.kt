package com.example.goodscenter.data.repository

import com.example.baselibrary.data.net.RetrofitFactory
import com.example.baselibrary.data.protocol.BaseResp
import com.example.goodscenter.data.api.CategoryApi
import com.example.goodscenter.data.protocol.Category
import com.example.goodscenter.data.protocol.GetCategoryReq
import rx.Observable
import javax.inject.Inject

/**
 * Created by mac on 2018/6/15.
 *
 * 商品分类 数据层
 */
class CategoryRepository @Inject constructor() {

    // 获取商品分类
    fun getCategory(parentId: Int): Observable<BaseResp<MutableList<Category>?>> {
        return RetrofitFactory.instance.create(CategoryApi::class.java).getCategory(GetCategoryReq(parentId))
    }

}