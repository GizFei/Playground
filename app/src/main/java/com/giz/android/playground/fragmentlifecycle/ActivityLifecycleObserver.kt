package com.giz.android.playground.fragmentlifecycle

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.fragment.app.FragmentActivity

/**
 * Description of the file
 * Created by GizFei on 2021/1/31
 */
class ActivityLifecycleObserver : Application.ActivityLifecycleCallbacks {

    override fun onActivityPaused(activity: Activity) {

    }

    override fun onActivityStarted(activity: Activity) {

    }

    override fun onActivityDestroyed(activity: Activity) {

    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {

    }

    override fun onActivityStopped(activity: Activity) {

    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        if (activity is FragmentActivity) {
            activity.supportFragmentManager.registerFragmentLifecycleCallbacks(FragmentLifecycleObserver(), false)
        }
    }

    override fun onActivityResumed(activity: Activity) {

    }
}