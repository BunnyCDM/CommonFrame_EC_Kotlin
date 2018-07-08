package com.example.mac.commonframe_ec_kotlin.ui.adapter

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.baselibrary.ext.loadUrl
import com.example.mac.commonframe_ec_kotlin.R
import kotlinx.android.synthetic.main.layout_topic_item.view.*

/**
 * Created by mac on 2018/6/15.
 *
 * 话题数据
 */
class TopicAdapter(private val context: Context, private val list: List<String>) : PagerAdapter() {

    override fun destroyItem(parent: ViewGroup, position: Int, paramObject: Any) {
        parent.removeView(paramObject as View)
    }


    override fun getCount(): Int {
        return this.list.size
    }

    override fun instantiateItem(parent: ViewGroup, position: Int): Any {
        val rooView = LayoutInflater.from(this.context).inflate(R.layout.layout_topic_item, null)
        rooView.mTopicIv.loadUrl(list[position])
        parent.addView(rooView)
        return rooView
    }

    override fun isViewFromObject(paramView: View, paramObject: Any): Boolean {
        return paramView === paramObject
    }

}