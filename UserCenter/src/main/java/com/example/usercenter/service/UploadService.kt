package com.example.usercenter.service

import rx.Observable

/**
 * Created by mac on 2018/6/14.
 *
 * 上传业务接口
 */
interface UploadService {

    fun getUploadToken(): Observable<String>

}