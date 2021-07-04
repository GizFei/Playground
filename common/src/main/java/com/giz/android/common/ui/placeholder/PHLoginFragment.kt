package com.giz.android.common.ui.placeholder

import com.giz.android.common.R
import com.giz.android.common.databinding.LayoutPhLoginBinding
import com.giz.android.common.ui.base.MvvmBaseFragment
import com.giz.android.common.ui.common.PHLoginIntroPageData
import com.giz.android.common.ui.common.PHLoginIntroViewPagerAdapter

/**
 * Description of the file
 *
 * Created by GizFei on 2021/6/28
 */
class PHLoginFragment : MvvmBaseFragment<LayoutPhLoginBinding>() {

    override fun getLayoutId(): Int = R.layout.layout_ph_login

    override fun initView() {
        setupIntroViewPager()
    }

    private fun setupIntroViewPager() {
        mBinding.vpIntro.adapter = PHLoginIntroViewPagerAdapter(requireContext(), generatePageData())
    }

    private fun generatePageData() = PHLoginIntroPageData.generateDefaultData()

}