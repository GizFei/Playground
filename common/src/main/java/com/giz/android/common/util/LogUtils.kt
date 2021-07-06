package com.giz.android.common.util

/**
 * 日志工具类
 *
 * Created by GizFei on 2021/7/4
 */

inline fun logBottomSheet(msg: () -> String) {
    YFLog.e("BottomSheet", msg())
}

inline fun logLifecycle(lifecycle: () -> String) {
    YFLog.e("Lifecycle", "Lifecycle is: ${lifecycle()}")
}