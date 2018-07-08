package com.example.mac.commonframe_ec_kotlin.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.baselibrary.ui.fragment.BaseFragment
import com.example.baselibrary.widgets.BannerImageLoader
import com.example.mac.commonframe_ec_kotlin.R
import com.example.mac.commonframe_ec_kotlin.common.HOME_BANNER_FOUR
import com.example.mac.commonframe_ec_kotlin.common.HOME_BANNER_ONE
import com.example.mac.commonframe_ec_kotlin.common.HOME_BANNER_THREE
import com.example.mac.commonframe_ec_kotlin.common.HOME_BANNER_TWO
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by mac on 2018/6/15.
 *
 * 主界面Fragment
 */
class HomeFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_home, null)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initBanner()
        initNews()
        initDiscount()
        initTopic()
    }

    /*
    初始化视图
 */
    private fun initView() {

    }


    //初始化Banner
    private fun initBanner() {
        mHomeBanner.setImageLoader(BannerImageLoader())
        mHomeBanner.setImages(listOf(HOME_BANNER_ONE, HOME_BANNER_TWO, HOME_BANNER_THREE, HOME_BANNER_FOUR))
        mHomeBanner.setBannerAnimation(Transformer.Accordion)
        mHomeBanner.setDelayTime(2000)
        //设置指示器位置（当banner模式中有指示器时）
        mHomeBanner.setIndicatorGravity(BannerConfig.RIGHT)
        //banner设置方法全部调用完毕时最后调用
        mHomeBanner.start()
    }

    //初始化公告
    private fun initNews() {
    }

    //初始化折扣
    private fun initDiscount() {
    }

    //初始化主题
    private fun initTopic() {
    }

}