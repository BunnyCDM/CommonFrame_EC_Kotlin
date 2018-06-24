package com.example.usercenter.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.usercenter.R
import org.jetbrains.anko.toast

/**
 * Created by mac on 2018/6/14.
 *
 * 忘记密码界面
 */

class ForgetPwdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_pwd)

        toast("${intent.getIntExtra("id",-1)}")//测试跳转使用


    }
}
