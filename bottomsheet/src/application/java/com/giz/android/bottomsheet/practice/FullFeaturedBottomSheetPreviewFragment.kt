package com.giz.android.bottomsheet.practice

import android.annotation.SuppressLint
import android.os.Bundle
import com.giz.android.bottomsheet.R
import com.giz.android.bottomsheet.databinding.LayoutFullFeaturedBottomSheetWrapContentBinding
import com.giz.android.bottomsheet.fragment.BaseBottomSheetFragment
import com.giz.android.bottomsheet.util.BottomSheetOptions
import com.giz.android.common.util.logBottomSheet

/**
 * Description of the file
 *
 * Created by GizFei on 2021/7/5
 */
class FullFeaturedBottomSheetPreviewFragment :
    BaseBottomSheetFragment<LayoutFullFeaturedBottomSheetWrapContentBinding>() {

    companion object {
        const val TAG = "FullFeaturedBottomSheetPreviewDialog"

        fun newInstance(options: BottomSheetOptions = BottomSheetOptions()) = FullFeaturedBottomSheetPreviewFragment().apply {
            arguments = options.toBundle()
        }
    }

    private var mOptions = BottomSheetOptions()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        extractOptions()
    }

    private fun extractOptions() {
        mOptions = BottomSheetOptions.resolveBundle(arguments)
        logBottomSheet { "extractOptions: $mOptions" }
    }

    override fun getLayoutId(): Int = R.layout.layout_full_featured_bottom_sheet_wrap_content

    @SuppressLint("SetTextI18n")
    override fun initView() {
        mBinding.btnLogIn.setOnClickListener { dismissAllowingStateLoss() }
        mBinding.btnLogIn.text = "dismiss"
    }

    override fun getOptions(): BottomSheetOptions = mOptions

}