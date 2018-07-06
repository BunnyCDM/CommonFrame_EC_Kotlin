package com.example.usercenter.ui.activity

import android.os.Bundle
import android.view.View
import com.example.baselibrary.ext.OnClick
import com.example.baselibrary.ext.enale
import com.example.baselibrary.ui.activity.BaseMvpActivity
import com.example.provider.PushProvider
import com.example.usercenter.R
import com.example.usercenter.data.protocol.UserInfo
import com.example.usercenter.injection.component.DaggerUserComponent
import com.example.usercenter.injection.module.UserModule
import com.example.usercenter.presenter.LoginPresenter
import com.example.usercenter.presenter.view.LoginView
import com.example.usercenter.utils.UserPrefsUtils
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 * Created by mac on 2018/6/14.
 *
 * 登录界面
 */
class LoginActivity : BaseMvpActivity<LoginPresenter>(), LoginView, View.OnClickListener {

    var mPushProvider: PushProvider? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //toast("${intent.getIntExtra("id", -1)}")
        initView()
    }


    //初始化视图
    private fun initView() {
        mLoginBtn.enale(mMobileEt, { isBtnEnable() })
        mLoginBtn.enale(mPwdEt, { isBtnEnable() })

        mLoginBtn.OnClick(this)
        mHeaderBar.getRightView().OnClick(this)
        mForgetPwdTv.OnClick(this)
    }

    //Dagger注册
    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(mActivityComponent).userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }

    //点击事件
    override fun onClick(view: View) {
        when (view.id) {
            R.id.mRightTv -> {
                startActivity<RegisterActivity>()
            }

            R.id.mLoginBtn -> {
                mPresenter.login(mMobileEt.text.toString(), mPwdEt.text.toString(), mPushProvider?.getPushId() ?: "")
            }
            R.id.mForgetPwdTv -> {
                startActivity<ForgetPwdActivity>()
            }
        }
    }


    //判断按钮是否可用
    private fun isBtnEnable(): Boolean {
        return mMobileEt.text.isNullOrEmpty().not() &&
                mPwdEt.text.isNullOrEmpty().not()
    }

    //登录回调
    override fun onLoginResult(result: UserInfo) {
        toast("登录成功")
        UserPrefsUtils.putUserInfo(result)
        finish()
    }


}
