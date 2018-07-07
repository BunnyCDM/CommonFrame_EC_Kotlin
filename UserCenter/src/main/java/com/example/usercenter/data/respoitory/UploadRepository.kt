package com.example.usercenter.data.respoitory

import com.example.baselibrary.data.net.RetrofitFactory
import com.example.baselibrary.data.protocol.BaseResp
import com.example.usercenter.data.api.UploadApi
import rx.Observable
import javax.inject.Inject

/**
 * Created by mac on 2018/6/14.
 *
 * 上传相关数据层
 */
class UploadRepository @Inject constructor() {


    //获取七牛云上传凭证
    fun getUploadToken(): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(UploadApi::class.java).getUploadToken()
    }
}