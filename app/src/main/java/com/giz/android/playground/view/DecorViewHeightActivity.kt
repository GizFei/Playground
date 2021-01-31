package com.giz.android.playground.view

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.giz.android.playground.R
import com.giz.android.playground.utils.GLog
import kotlinx.android.synthetic.main.activity_decor_view_height.*

/**
 * 测试DecorView各部分视图高度的活动
 * Created by GizFei on 2021/1/24
 */
class DecorViewHeightActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_decor_view_height)

        window.decorView.post {
            GLog("Window height=${window.attributes.height}")
            GLog("DecorView height=${window.decorView.height}")
            GLog("DecorView#ContentView height=${window.decorView.findViewById<View>(android.R.id.content).height}")
            GLog("DecorView#StatusBar height=${window.decorView.findViewById<View>(android.R.id.statusBarBackground).height}")
            GLog("DecorView#NavigationBar height=${window.decorView.findViewById<View>(android.R.id.navigationBarBackground).height}")
            val statusBar = window.decorView.findViewById<View>(android.R.id.statusBarBackground)
            statusBar?.setBackgroundColor(Color.RED)
            val navigationBar = window.decorView.findViewById<View>(android.R.id.navigationBarBackground)
            navigationBar?.setBackgroundColor(Color.GRAY)

            val heightText = "Window height=${window.attributes.height}\n" +
                    "DecorView height=${window.decorView.height}\n" +
                    "DecorView#ContentView height=${window.decorView.findViewById<View>(android.R.id.content).height}\n" +
                    "DecorView#StatusBar height=${window.decorView.findViewById<View>(android.R.id.statusBarBackground).height}\n" +
                    "DecorView#NavigationBar height=${window.decorView.findViewById<View>(android.R.id.navigationBarBackground).height}"
            tvPrintHeight.text = heightText
        }
        supportActionBar?.title = this::class.simpleName
    }
}