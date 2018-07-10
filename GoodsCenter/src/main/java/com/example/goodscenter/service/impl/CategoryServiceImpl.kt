package com.example.goodscenter.service.impl

import com.example.baselibrary.ext.convert
import com.example.goodscenter.data.protocol.Category
import com.example.goodscenter.data.repository.CategoryRepository
import com.example.goodscenter.service.CategoryService
import rx.Observable
import javax.inject.Inject

/**
 * Created by mac on 2018/6/15.
 *
 * 商品分类 业务层 实现类
 */
class CategoryServiceImpl @Inject constructor() : CategoryService {
    @Inject
    lateinit var repository: CategoryRepository


    //获取商品分类列表
    override fun getCategory(parentId: Int): Observable<MutableList<Category>?> {
        return repository.getCategory(parentId).convert()
    }


}