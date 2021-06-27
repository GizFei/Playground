package com.giz.android.views.tab

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.forEach
import androidx.core.view.forEachIndexed
import com.giz.android.views.databinding.FragmentLightSettingsBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 * 灯光设置Fragment
 *
 * Created by GizFei on 2021/3/20
 */
class LightSettingsFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentLightSettingsBinding? = null
    private val mBinding: FragmentLightSettingsBinding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentLightSettingsBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mBinding.viewPager.adapter = LightSettingsPagerAdapter()

//        mBinding.tabLayout.setupWithViewPager(mBinding.viewPager)
//
//        mBinding.tabLayout.addOnTabSelectedListener(object : SlideBgTabLayout.OnTabSelectedListener {
//            override fun onTabSelected(position: Int) {
//                mBinding.tabLayout.forEachIndexed { idx, tv ->
//                    if (tv is TextView) {
//                        tv.setTextColor(if (idx == position) Color.WHITE else Color.BLACK  )
//                    }
//                }
//            }
//        })
//        mBinding.tabLayout.selectTab(1)

        mBinding.materialTabLayout.setupWithViewPager(mBinding.viewPager)
        mBinding.materialTabLayout.selectTab(mBinding.materialTabLayout.getTabAt(1))
    }

}