package com.example.usercenter.service.impl

import com.example.baselibrary.ext.convert
import com.example.usercenter.data.respoitory.UploadRepository
import com.example.usercenter.service.UploadService
import rx.Observable
import javax.inject.Inject

/**
 * Created by mac on 2018/6/14.
 *
 * 上传业务实现类
 */
class UploadServiceImpl @Inject constructor() : UploadService {

    @Inject
    lateinit var respsitory: UploadRepository

    override fun getUploadToken(): Observable<String> {
        return respsitory.getUploadToken().convert()

    }
}