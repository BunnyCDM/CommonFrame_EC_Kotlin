package com.example.usercenter.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.baselibrary.ext.OnClick
import com.example.baselibrary.ui.activity.BaseMvpActivity
import com.example.usercenter.R
import com.example.usercenter.injection.component.DaggerUserComponent
import com.example.usercenter.injection.module.UserModule
import com.example.usercenter.presenter.RegisterPresenter
import com.example.usercenter.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import java.util.*

/**
 * Created by mac on 2018/6/14.
 *
 * 注册界面
 */
class RegisterActivity : BaseMvpActivity<RegisterPresenter>(),RegisterView {

    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(activityComponent).userModule(UserModule()).build().inject(this)
        mPresenter.mView=this
    }

    override fun onRegisterResult(result: String) {
        toast(result) //注册成功
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mRegisterBtn.setOnClickListener {
            //Log.d("RegisterActivity", "注册")
            //Toast.makeText(this, "注册", Toast.LENGTH_SHORT).show()
            toast("注册")

            //startActivity(intentFor<ForgetPwdActivity>("id" to 5))

            //startActivity<ForgetPwdActivity>("id" to 10)

            //startActivity<ForgetPwdActivity>()


            //mPresenter=RegisterPresenter() //如果添加注解可直接删除
            //mPresenter.mView=this;

            //initInjection()

            mPresenter.register("","","")
            //mPresenter.register2("","")
            //mPresenter.register3("","")
            //mPresenter.register3(mMobileEt.text.toString(),mVerifyCodeEt.text.toString(),mPwdEt.text.toString())
        }


        mVerifyCodeBtn.setOnClickListener {
            mPresenter.register4(mMobileEt.text.toString(),mVerifyCodeEt.text.toString(),mPwdEt.text.toString())
        }

        mVerifyCodeBtn.OnClick(object :View.OnClickListener{
            override fun onClick(p0: View?) {
                toast("自定义事件1")
            }
        })

        mVerifyCodeBtn.OnClick{
            toast("自定义事件2")
        }

    }

//    private fun initInjection(){
//        DaggerUserComponent.builder().activityComponent(activityComponent).userModule(UserModule()).build().inject(this)
//
//        mPresenter.mView=this
//    }

}
