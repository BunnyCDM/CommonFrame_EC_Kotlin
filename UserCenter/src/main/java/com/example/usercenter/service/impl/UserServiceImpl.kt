package com.example.usercenter.service.impl

import com.example.baselibrary.rx.BaseFunc
import com.example.baselibrary.rx.BaseFuncBoolean
import com.example.usercenter.data.respoitory.UserRepository
import com.example.usercenter.service.UserService
import rx.Observable
import javax.inject.Inject

/**
 * Created by mac on 2018/6/14.
 */
class UserServiceImpl @Inject constructor() : UserService {

    override fun register1(mobile: String, verifyCode: String, pwd: String):
            Observable<Boolean> {

        return Observable.just(true)

//        return repository.register(mobile, pwd, verifyCode)
//                .flatMap(BaseFuncBoolean()) //等价与.convertBoolean()
    }

    override fun register2(mobile: String, verifyCode: String, pwd: String):
            Observable<String> {
        return repository.register(mobile, pwd, verifyCode)
                .flatMap(BaseFunc())
    }

    @Inject
    lateinit var repository: UserRepository


//    override fun register(mobile: String, verifyCode: String, pwd: String):
//            Observable<Boolean> {
//        return repository.register(mobile, pwd, verifyCode)
//                .flatMap (object :Func1<BaseResp<String>,Observable<Boolean>>{
//
//                    override fun call(t: BaseResp<String>): Observable<Boolean> {
//                        if(t.status!=0){
//                            return Observable.error(BaseException(t.status,t.message))
//                        }
//                        return Observable.just(true)
//                    }
//
//                })
//    }


}