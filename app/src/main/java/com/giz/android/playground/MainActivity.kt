package com.giz.android.playground

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.giz.android.playground.utils.GLog
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    private lateinit var mToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mToolbar = findViewById(R.id.toolbar)
        mToolbar.setNavigationIcon(R.drawable.ic_round_arrow_back)
//        setSupportActionBar(mToolbar)
        mToolbar.setNavigationOnClickListener {
            finish()
        }
    }

    fun onClick(view: View) {
        view.setOnClickListener {
            try {
                val clz = Class.forName(it.tag as? String ?: "com.giz.android.MainActivity")
                startActivity(Intent(this, clz))
            } catch (e: Exception) {
                Toast.makeText(this, "跳转错误", Toast.LENGTH_SHORT).show()
            }
        }
    }
}