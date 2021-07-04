package com.giz.android.bottomsheet.practice

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.giz.android.bottomsheet.R
import com.giz.android.bottomsheet.dialog.BaseBottomSheetDialog
import com.giz.android.bottomsheet.util.BottomSheetFeature
import com.giz.android.bottomsheet.util.BottomSheetFeatureImpl
import com.giz.android.bottomsheet.util.BottomSheetOptions
import com.giz.android.common.databinding.LayoutFullFeaturedBottomSheetBinding
import com.giz.android.common.util.logBottomSheet
import com.giz.android.common.util.logLifecycle
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 * 包含全部特性的BottomSheetDialog
 *
 * Created by GizFei on 2021/7/2
 */
class FullFeaturedBottomSheetPreviewDialog() : BaseBottomSheetDialog<LayoutFullFeaturedBottomSheetBinding>() {

    companion object {
        const val TAG = "FullFeaturedBottomSheetPreviewDialog"

        fun newInstance(options: BottomSheetOptions = BottomSheetOptions()) = FullFeaturedBottomSheetPreviewDialog().apply {
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

    override fun getLayoutId(): Int = R.layout.layout_full_featured_bottom_sheet

    @SuppressLint("SetTextI18n")
    override fun initView() {
        mBinding.btnLogIn.setOnClickListener { dismissAllowingStateLoss() }
        mBinding.btnLogIn.text = "dismiss"
    }

    override fun customizeDialog(dialog: BottomSheetDialog) {
        addCallback(dialog)
    }

    override fun getOptions(): BottomSheetOptions? = mOptions

    private fun addCallback(dialog: BottomSheetDialog) {
        dialog.behavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                logBottomSheet { "BottomSheetBehavior onStateChanged: ${convertState(newState)}" }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {}
        })
    }

    private fun convertState(state: Int): String {
        return when (state) {
            1 -> "STATE_DRAGGING"
            2 -> "STATE_SETTLING"
            3 -> "STATE_EXPANDED"
            4 -> "STATE_COLLAPSED"
            5 -> "STATE_HIDDEN"
            6 -> "STATE_HALF_EXPANDED"
            else -> "Unknown State"
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        logLifecycle { "onDestroy" }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        logLifecycle { "onDestroyView" }
    }

    override fun onDetach() {
        super.onDetach()
        logLifecycle { "onDetach" }
    }

}