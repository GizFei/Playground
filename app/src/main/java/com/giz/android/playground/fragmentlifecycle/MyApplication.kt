package com.giz.android.playground.fragmentlifecycle

import android.app.Application

/**
 * Description of the file
 * Created by GizFei on 2021/1/31
 */
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        registerActivityLifecycleCallbacks(ActivityLifecycleObserver())
    }
}