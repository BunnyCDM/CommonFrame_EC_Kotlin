package com.example.baselibrary.injection

import java.lang.annotation.Documented
import java.lang.annotation.Retention
import javax.inject.Scope
import java.lang.annotation.RetentionPolicy.RUNTIME

/**
 * Created by mac on 2018/6/14.
 *
 * Activity级别 作用域
 */

@Scope
@Documented
@Retention(RUNTIME)
annotation class ActivityScope