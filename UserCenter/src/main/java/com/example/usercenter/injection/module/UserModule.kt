package com.example.usercenter.injection.module

import com.example.usercenter.service.UserService
import com.example.usercenter.service.impl.UserServiceImpl
import com.example.usercenter.service.impl.UserServiceImpl2
import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * Created by mac on 2018/6/14.
 */

@Module
class UserModule {

    @Provides
    @Named("service")
    fun providesUserService(service: UserServiceImpl): UserService {
        return service
    }

    @Provides
    @Named("service2")
    fun providesUserService2(service: UserServiceImpl2): UserService {
        return service
    }



}