package com.giz.android.viewtest.tab

import com.giz.android.bottomsheet.dialog.BaseBottomSheetDialog
import com.giz.android.viewtest.R
import com.giz.android.viewtest.databinding.FragmentLightSettingsBinding

/**
 * Created by GizFei on 2021/7/8
 */
class LightSettingsDialog : BaseBottomSheetDialog<FragmentLightSettingsBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_light_settings

    override fun initView() {
        mBinding.viewPager.adapter = LightSettingsPagerAdapter()
        mBinding.materialTabLayout.setupWithViewPager(mBinding.viewPager)
        mBinding.materialTabLayout.selectTab(mBinding.materialTabLayout.getTabAt(1))
    }

}