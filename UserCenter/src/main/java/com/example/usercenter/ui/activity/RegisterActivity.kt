package com.example.usercenter.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 * Created by mac on 2018/6/14.
 *
 * 注册界面
 */
class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.usercenter.R.layout.activity_register)

        mVerifyCodeBtn.setOnClickListener {
            //Toast.makeText(this,"获取验证码",Toast.LENGTH_SHORT).show()
            toast("获取验证码")
        }

        mRegisterBtn.setOnClickListener {
            //Toast.makeText(this,"注册",Toast.LENGTH_SHORT).show()
            toast("注册")

            //startActivity(intentFor<LoginActivity>("id" to 5))
            startActivity<LoginActivity>("id" to 10)
        }

    }

}
