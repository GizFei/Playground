package com.giz.android.views.tab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.giz.android.views.R
import com.giz.android.views.databinding.ActivityLightSettingsBinding

class LightSettingsActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityLightSettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_light_settings)

        supportFragmentManager.beginTransaction()
            .add(R.id.container, LightSettingsFragment())
            .commit()

        mBinding.btnShowSheet.setOnClickListener {
            LightSettingsFragment().show(supportFragmentManager, null)
        }
    }
}