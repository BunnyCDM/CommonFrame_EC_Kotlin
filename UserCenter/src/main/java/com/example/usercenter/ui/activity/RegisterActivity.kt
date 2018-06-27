package com.example.usercenter.ui.activity

import android.os.Bundle
import android.view.View
import com.example.baselibrary.ext.OnClick
import com.example.baselibrary.ui.activity.BaseMvpActivity
import com.example.usercenter.injection.component.DaggerUserComponent
import com.example.usercenter.injection.module.UserModule
import com.example.usercenter.presenter.RegisterPresenter
import com.example.usercenter.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast

/**
 * Created by mac on 2018/6/14.
 *
 * 注册界面
 */
class RegisterActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView {

    override fun onRegisterResult(result: String) {
        toast(result)
    }

    override fun injectComponent() {
        DaggerUserComponent.builder()
                .activityComponent(activityComponent)
                .userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.usercenter.R.layout.activity_register)

        mVerifyCodeBtn.setOnClickListener {
            //Toast.makeText(this,"获取验证码",Toast.LENGTH_SHORT).show()
            toast("获取验证码")

            mPresenter.register2_2(mMobileEt.text.toString(),
                    mVerifyCodeEt.text.toString(),
                    mPwdEt.text.toString())
        }

        mRegisterBtn.setOnClickListener {
            //Toast.makeText(this,"注册",Toast.LENGTH_SHORT).show()
            toast("注册")

            //startActivity(intentFor<LoginActivity>("id" to 5))
            //startActivity<LoginActivity>("id" to 10)

            //register1
//            mPresenter = RegisterPresenter()
//            mPresenter.mView = this
//            mPresenter.register1("", "", "")

            //register2
            //mPresenter = RegisterPresenter() //(采用依赖注入后不需要了)
            //mPresenter.mView = this //单独放在initInjection已经进行初始化了
            mPresenter.register2(mMobileEt.text.toString(),
                    mVerifyCodeEt.text.toString(),
                    mPwdEt.text.toString())
        }

//        mRegisterBtn.OnClick(object :View.OnClickListener{
//            override fun onClick(p0: View?) {
//                toast("注册2")
//            }
//        })

//        mRegisterBtn.OnClick{
//            toast("注册3")
//        }




    }


}
