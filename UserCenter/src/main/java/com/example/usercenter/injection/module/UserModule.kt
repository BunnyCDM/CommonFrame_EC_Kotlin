package com.example.usercenter.injection.module

import com.example.usercenter.service.UserService
import com.example.usercenter.service.impl.UserServiceImpl
import dagger.Module
import dagger.Provides

/**
 * Created by mac on 2018/6/14.
 */

@Module
class UserModule {

    @Provides
    fun providesUserService(service: UserServiceImpl): UserService {
        return service
    }


}