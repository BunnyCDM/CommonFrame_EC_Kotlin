package com.example.mac.commonframe_ec_kotlin.ui.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import com.eightbitlab.rxbus.Bus
import com.example.baselibrary.common.AppManager
import com.example.baselibrary.ui.activity.BaseActivity
import com.example.mac.commonframe_ec_kotlin.R
import com.example.mac.commonframe_ec_kotlin.ui.fragment.HomeFragment
import org.jetbrains.anko.toast
import java.util.*

/**
 * Created by mac on 2018/6/15.
 *
 * 主界面
 */
class MainActivity : BaseActivity() {

    private var pressTime: Long = 0
    //Fragment 栈管理
    private val mStack = Stack<Fragment>()
    //主界面Fragment
    private val mHomeFragment by lazy { HomeFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFragment()
        initBottomNav()
        changeFragment(0)
        initObserve()
        loadCartSize()
    }

    //初始化Fragment栈管理
    private fun initFragment() {
        val manager = supportFragmentManager.beginTransaction()
        manager.add(R.id.mContaier, mHomeFragment)
        manager.commit()

        mStack.add(mHomeFragment)

    }

    private fun loadCartSize() {
    }

    private fun initObserve() {
    }

    private fun changeFragment(i: Int) {}

    private fun initBottomNav() {

    }


    //取消Bus事件监听
    override fun onDestroy() {
        super.onDestroy()
        Bus.unregister(this)
    }

    //重写Back事件，双击退出
    override fun onBackPressed() {
        val time = System.currentTimeMillis()
        if (time - pressTime > 2000) {
            toast("再按一次退出程序")
            pressTime = time
        } else {
            AppManager.instance.exitApp(this)
        }
    }
}


