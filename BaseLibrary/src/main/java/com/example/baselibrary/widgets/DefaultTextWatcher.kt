package com.example.baselibrary.widgets

import android.text.Editable
import android.text.TextWatcher

/**
 * Created by mac on 2018/6/14.
 *
 * 默认TextWatcher，空实现
 */
open class DefaultTextWatcher : TextWatcher {
    override fun afterTextChanged(s: Editable?) {
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }
}