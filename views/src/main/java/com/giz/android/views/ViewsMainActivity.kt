package com.giz.android.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class ViewsMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_views_main)
    }

    fun onClick(view: View) {
        try {
            val clz = Class.forName(view.tag as? String ?: "com.giz.android.MainActivity")
            startActivity(Intent(this, clz))
        } catch (e: Exception) {
            Toast.makeText(this, "跳转错误", Toast.LENGTH_SHORT).show()
        }
    }
}