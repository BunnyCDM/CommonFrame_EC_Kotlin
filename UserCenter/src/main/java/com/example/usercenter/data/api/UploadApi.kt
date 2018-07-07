package com.example.usercenter.data.api

import com.example.baselibrary.data.protocol.BaseResp
import retrofit2.http.POST
import rx.Observable

/**
 * Created by mac on 2018/6/14.
 *
 * 上传相关接口
 *
 */
interface UploadApi {


    //获取七牛云上传凭证
    @POST("common/getUploadToken")
    fun getUploadToken(): Observable<BaseResp<String>>
}