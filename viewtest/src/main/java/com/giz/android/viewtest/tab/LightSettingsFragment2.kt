package com.giz.android.viewtest.tab

import com.giz.android.bottomsheet.fragment.BaseBottomSheetFragment
import com.giz.android.viewtest.R
import com.giz.android.viewtest.databinding.FragmentLightSettingsBinding

/**
 * Created by GizFei on 2021/7/8
 */
class LightSettingsFragment2 : BaseBottomSheetFragment<FragmentLightSettingsBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_light_settings

    override fun initView() {
        mBinding.viewPager.adapter = LightSettingsPagerAdapter()
        mBinding.materialTabLayout.setupWithViewPager(mBinding.viewPager)
        mBinding.materialTabLayout.selectTab(mBinding.materialTabLayout.getTabAt(1))
    }

}