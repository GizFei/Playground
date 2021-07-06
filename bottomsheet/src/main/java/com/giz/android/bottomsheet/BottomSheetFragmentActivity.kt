package com.giz.android.bottomsheet

import com.giz.android.bottomsheet.databinding.ActivityBottomSheetFragmentBinding
import com.giz.android.bottomsheet.practice.FullFeaturedBottomSheetPreviewFragment
import com.giz.android.bottomsheet.util.BottomSheetOptions
import com.giz.android.common.ui.base.MvvmBaseActivity

class BottomSheetFragmentActivity : MvvmBaseActivity<ActivityBottomSheetFragmentBinding>() {

    override fun getLayoutId(): Int = R.layout.activity_bottom_sheet_fragment

    override fun initView() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, getFullFeaturedPreviewFragment())
            .commitAllowingStateLoss()
    }

    private fun getFullFeaturedPreviewFragment() = FullFeaturedBottomSheetPreviewFragment.newInstance(
        BottomSheetOptions()
            .fullscreen()
            .topRoundCorner()
    )

}