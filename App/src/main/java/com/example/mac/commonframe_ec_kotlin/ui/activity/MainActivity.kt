package com.example.mac.commonframe_ec_kotlin.ui.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.eightbitlab.rxbus.Bus
import com.eightbitlab.rxbus.registerInBus
import com.example.baselibrary.common.AppManager
import com.example.baselibrary.ui.activity.BaseActivity
import com.example.baselibrary.utils.AppPrefsUtils
import com.example.goodscenter.common.GoodsConstant
import com.example.goodscenter.event.UpdateCartSizeEvent
import com.example.goodscenter.ui.fragment.CartFragment
import com.example.goodscenter.ui.fragment.CategoryFragment
import com.example.mac.commonframe_ec_kotlin.R
import com.example.mac.commonframe_ec_kotlin.ui.fragment.HomeFragment
import com.example.mac.commonframe_ec_kotlin.ui.fragment.MeFragment
import com.example.messagecenter.ui.fragment.MessageFragment
import com.example.provider.event.MessageBadgeEvent
import kotlinx.android.synthetic.main.activity_main.*
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
    //商品分类Fragment
    private val mCategoryFragment by lazy { CategoryFragment() }
    //购物车Fragment
    private val mCartFragment by lazy { CartFragment() }
    //消息Fragment
    private val mMsgFragment by lazy { MessageFragment() }
    //"我的"Fragment
    private val mMeFragment by lazy { MeFragment() }

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
        manager.add(R.id.mContaier,mCategoryFragment)
        manager.add(R.id.mContaier,mCartFragment)
        manager.add(R.id.mContaier,mMsgFragment)
        manager.add(R.id.mContaier, mMeFragment)
        manager.commit()

        mStack.add(mHomeFragment)
        mStack.add(mCategoryFragment)
        mStack.add(mCartFragment)
        mStack.add(mMsgFragment)
        mStack.add(mMeFragment)

    }

    // 切换Tab，切换对应的Fragment
    private fun changeFragment(position: Int) {
        val manager = supportFragmentManager.beginTransaction()
        for (fragment in mStack) {
            manager.hide(fragment)
        }

        manager.show(mStack[position])
        manager.commit()
    }

    //初始化底部导航切换事件
    private fun initBottomNav() {
        mBottomNavBar.setTabSelectedListener(object : BottomNavigationBar.OnTabSelectedListener {
            override fun onTabReselected(position: Int) {
            }

            override fun onTabUnselected(position: Int) {
            }

            override fun onTabSelected(position: Int) {
                changeFragment(position)
            }
        })

        mBottomNavBar.checkMsgBadge(false)
    }

    // 初始化监听，购物车数量变化及消息标签是否显示
    private fun initObserve() {
        Bus.observe<UpdateCartSizeEvent>()
                .subscribe {
                    loadCartSize()
                }.registerInBus(this)

        Bus.observe<MessageBadgeEvent>()
                .subscribe {
                    t: MessageBadgeEvent ->
                    run {
                        mBottomNavBar.checkMsgBadge(t.isVisible)
                    }
                }.registerInBus(this)
    }

    //加载购物车数量
    private fun loadCartSize() {
        mBottomNavBar.checkCartBadge(AppPrefsUtils.getInt(GoodsConstant.SP_CART_SIZE))
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


