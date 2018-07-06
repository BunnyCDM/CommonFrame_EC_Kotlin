package com.example.usercenter.ui.activity

import android.os.Bundle
import android.view.View
import com.example.baselibrary.ext.OnClick
import com.example.baselibrary.ext.enale
import com.example.baselibrary.ui.activity.BaseMvpActivity
import com.example.usercenter.R
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
class RegisterActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView, View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.usercenter.R.layout.activity_register)
        initView()
    }

    //初始化视图
    private fun initView() {
        mRegisterBtn.enale(mMobileEt, { isBtnEnable() })
        mRegisterBtn.enale(mVerifyCodeEt, { isBtnEnable() })
        mRegisterBtn.enale(mPwdEt, { isBtnEnable() })
        mRegisterBtn.enale(mPwdConfirmEt, { isBtnEnable() })

        mVerifyCodeBtn.OnClick(this)
        mRegisterBtn.OnClick(this)
    }

    //Dagger注册
    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(mActivityComponent).userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }

    //注册回调
    override fun onRegisterResult(result: String) {
        toast(result)
        finish()
    }

    //点击事件
    override fun onClick(view: View) {
        when (view.id) {
            R.id.mVerifyCodeBtn -> {
                toast("获取验证码") //默认123456
                mVerifyCodeBtn.requestSendVerifyNumber()
            }

            R.id.mRegisterBtn -> {
                //toast("注册")
                mPresenter.register(mMobileEt.text.toString(), mPwdEt.text.toString(), mVerifyCodeEt.text.toString())
            }

        }
    }

    //判断按钮是否可用
    private fun isBtnEnable(): Boolean {
        return mMobileEt.text.isNullOrEmpty().not() &&
                mVerifyCodeEt.text.isNullOrEmpty().not() &&
                mPwdEt.text.isNullOrEmpty().not() &&
                mPwdConfirmEt.text.isNullOrEmpty().not()
    }


}
