package com.giz.android.playground.utils

import android.content.Context
import android.util.Log

/**
 * Created by GizFei on 2021/1/24
 */

fun Context.GLog(msg: String?) = Log.d(this::class.simpleName,  msg ?: "Null Message")