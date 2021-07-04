package com.giz.android.common.util

import android.util.Log

/**
 * Description of the file
 *
 * Created by GizFei on 2021/7/4
 */

inline fun logBottomSheet(msg: () -> String) {
    Log.e("BottomSheet", msg())
}

inline fun logLifecycle(lifecycle: () -> String) {
    Log.e("Lifecycle", "Lifecycle is: ${lifecycle()}")
}