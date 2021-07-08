package com.giz.android.views.tab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.giz.android.bottomsheet.dialog.BaseBottomSheetDialog.Companion.withOptions
import com.giz.android.bottomsheet.fragment.BaseBottomSheetFragment.Companion.withOptions
import com.giz.android.bottomsheet.util.BottomSheetOptions
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
        mBinding.btnShowSheet2.setOnClickListener {
            val options = BottomSheetOptions()
                .topRoundCorner()
                .fullscreen()
            LightSettingsFragment2().withOptions(options).show(supportFragmentManager, null)
        }
        mBinding.btnShowDialog.setOnClickListener {
            val options = BottomSheetOptions()
                .topRoundCorner()
                .fullscreen()
            LightSettingsDialog().withOptions(options).show(supportFragmentManager, null)
        }
    }
}