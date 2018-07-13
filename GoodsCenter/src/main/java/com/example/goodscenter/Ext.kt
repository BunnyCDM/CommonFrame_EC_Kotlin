package com.example.goodscenter

import android.widget.EditText
import org.jetbrains.anko.find
import ren.qinc.numberbutton.NumberButton
import ren.qinc.numberbutton.R

/**
 * Created by mac on 2018/7/12.
 *
 * 三方控件扩展
 */

fun NumberButton.getEditText(): EditText {
    return find(R.id.text_count)
}
