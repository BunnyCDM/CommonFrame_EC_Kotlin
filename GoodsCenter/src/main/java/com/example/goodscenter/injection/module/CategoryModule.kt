package com.example.goodscenter.injection.module

import com.example.goodscenter.service.CategoryService
import com.example.goodscenter.service.impl.CategoryServiceImpl
import dagger.Module
import dagger.Provides

/**
 * Created by mac on 2018/6/15.
 *
 * 商品分类Module
 */
@Module
class CategoryModule {

    @Provides
    fun provideCategoryService(categoryService: CategoryServiceImpl): CategoryService {
        return categoryService
    }

}