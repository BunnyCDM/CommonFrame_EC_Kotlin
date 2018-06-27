package com.example.usercenter.service.impl

import com.example.baselibrary.data.protocol.BaseResp
import com.example.baselibrary.rx.BaseException
import com.example.baselibrary.rx.BaseFunc
import com.example.usercenter.data.respoitory.UserRepository
import com.example.usercenter.service.UserService
import rx.Observable
import rx.functions.Func1
import javax.inject.Inject

/**
 * Created by mac on 2018/6/27.
 */
class UserServiceImpl2 @Inject constructor() : UserService {

    @Inject
    lateinit var repository: UserRepository

    override fun register1(mobile: String, verifyCode: String, pwd: String):
            Observable<Boolean> {

        return repository.register(mobile, pwd, verifyCode)
                .flatMap(object : Func1<BaseResp<String>, Observable<Boolean>> {

                    override fun call(t: BaseResp<String>): Observable<Boolean> {
                        if (t.status != 0) {
                            return Observable.error(BaseException(t.status, t.message))
                        }
                        return Observable.just(false)
                    }

                })

    }

    override fun register2(mobile: String, verifyCode: String, pwd: String):
            Observable<String> {
        val repository = UserRepository()
        return repository.register(mobile, pwd, verifyCode)
                .flatMap(BaseFunc())
    }


}