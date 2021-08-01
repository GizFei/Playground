package com.giz.android.common.util

import android.content.Context
import android.util.TypedValue

/**
 * Created by GizFei on 2021/7/9
 */
fun Context.dp2px(dp: Int): Float = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
    dp.toFloat(), this.resources.displayMetrics)

fun Context.dp2pixelSize(dp: Int): Int = dp2px(dp).toInt()

fun Context.getScreenHeight(): Int {
    return this.resources.displayMetrics.heightPixels
}