package com.example.baselibrary.rx

/**
 * Created by mac on 2018/6/14.
 *
 * 定义通用异常
 */
class BaseException(val status: Int, val msg: String) : Throwable()