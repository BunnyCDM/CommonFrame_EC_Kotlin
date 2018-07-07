package com.example.usercenter.ui.activity

import android.os.Bundle
import com.bigkoo.alertview.AlertView
import com.bigkoo.alertview.OnItemClickListener
import com.example.baselibrary.ext.onClick
import com.example.baselibrary.ui.activity.BaseMvpActivity
import com.example.usercenter.R
import com.example.usercenter.data.protocol.UserInfo
import com.example.usercenter.injection.component.DaggerUserComponent
import com.example.usercenter.injection.module.UserModule
import com.example.usercenter.presenter.UserInfoPresenter
import com.example.usercenter.presenter.view.UserInfoView
import kotlinx.android.synthetic.main.activity_user_info.*
import org.jetbrains.anko.toast

/**
 * Created by mac on 2018/6/14.
 *
 * 用户信息
 */

class UserInfoActivity : BaseMvpActivity<UserInfoPresenter>(), UserInfoView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)

        initView()
        initData()
    }


    //初始化视图
    private fun initView() {
        mUserIconView.onClick {
            AlertView("选择图片", "", "取消", null, arrayOf("拍照", "相册"), this,
                    AlertView.Style.ActionSheet, OnItemClickListener { o, position ->
                when (position) {
                    0 -> {
                        toast("拍照")
                    }
                    1 -> toast("相册")
                }
            }

            ).show()
        }
    }

    //初始化数据
    private fun initData() {
    }

    //Dagger注册
    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(mActivityComponent).userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }

    override fun onGetUploadTokenResult(result: String) {
    }

    override fun onEditUserResult(result: UserInfo) {
    }

}
