package com.example.usercenter.injection.module

import com.example.usercenter.service.UploadService
import com.example.usercenter.service.impl.UploadServiceImpl
import dagger.Module
import dagger.Provides

/**
 * Created by mac on 2018/6/14.
 *
 * 上传Module
 */
@Module
class UploadModule {

    @Provides
    fun provideUploadService(uploadService: UploadServiceImpl): UploadService {
        return uploadService
    }
}