package com.giz.android.playground.fragmentlifecycle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.giz.android.playground.R

/**
 * Description of the file
 * Created by GizFei on 2021/1/31
 */
class TestFragmentLifecycleObserverActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_fragment_lifecycle_observer)

        initFragment()
    }

    private fun initFragment() {
        val fragment = TestFragment()
        supportFragmentManager.beginTransaction()
                .add(R.id.rootView, fragment)
                .commitAllowingStateLoss()
    }

}