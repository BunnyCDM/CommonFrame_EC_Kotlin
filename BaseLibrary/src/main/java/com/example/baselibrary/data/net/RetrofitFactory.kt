package com.example.baselibrary.data.net

import com.example.baselibrary.common.BaseConstant
import com.example.baselibrary.utils.AppPrefsUtils
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by mac on 2018/6/14.
 *
 * Retrofit 工厂，单例
 */
class RetrofitFactory private constructor() {

    //单例实现,lazy本身就线程安全
    companion object { //这种写法就相当于java中public static
        val instance: RetrofitFactory by lazy { RetrofitFactory() }
    }

    private val retrofit: Retrofit
    private val interceptor: Interceptor

    //初始化
    init {
        //通用拦截
        interceptor = Interceptor {
            chain ->
            val requset = chain.request()
                    .newBuilder()
                    .addHeader("Content_Type", "application/json")
                    .addHeader("charset", "UTF-8")
                    .addHeader("token", AppPrefsUtils.getString(BaseConstant.KEY_SP_TOKEN))
                    .build()

            chain.proceed(requset)
        }

        //Retrofit实例化
        retrofit = Retrofit.Builder()
                .baseUrl(BaseConstant.SERVER_ADDRESS)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(initClient())
                .build()
    }

    //OkHttp创建
    private fun initClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(initLogInterceptor())
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build()
    }

    //日志拦截器
    private fun initLogInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    //具体服务实例化
    fun <T> create(service: Class<T>): T {
        return retrofit.create(service)
    }

}