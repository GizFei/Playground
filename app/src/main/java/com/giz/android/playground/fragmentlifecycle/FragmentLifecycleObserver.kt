package com.giz.android.playground.fragmentlifecycle

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

/**
 * Description of the file
 * Created by GizFei on 2021/1/31
 */
class FragmentLifecycleObserver : FragmentManager.FragmentLifecycleCallbacks() {

    override fun onFragmentViewCreated(fm: FragmentManager, f: Fragment, v: View, savedInstanceState: Bundle?) {
        Log.d(f::class.simpleName, "onFragmentViewCreated: ")
    }

    override fun onFragmentResumed(fm: FragmentManager, f: Fragment) {
        Log.d(f::class.simpleName, "onFragmentResumed: ")
    }

}