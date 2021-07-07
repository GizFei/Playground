package com.giz.android.bottomsheet

import android.content.Intent
import android.util.TypedValue
import com.giz.android.bottomsheet.databinding.ActivityBottomSheetMainBinding
import com.giz.android.bottomsheet.dialog.BaseBottomSheetDialog
import com.giz.android.bottomsheet.practice.FullFeaturedBottomSheetDialog
import com.giz.android.bottomsheet.practice.FullFeaturedBottomSheetPreviewDialog
import com.giz.android.bottomsheet.practice.FullFeaturedBottomSheetPreviewFragment
import com.giz.android.bottomsheet.util.BottomSheetOptions
import com.giz.android.common.ui.base.MvvmBaseActivity

class BottomSheetMainActivity : MvvmBaseActivity<ActivityBottomSheetMainBinding>() {

    override fun getLayoutId(): Int = R.layout.activity_bottom_sheet_main

    override fun initView() {
        mBinding.btnFullFeaturedDialog.setOnClickListener {
            showFullFeaturedBottomSheetDialog()
        }
        mBinding.btnFullscreen.setOnClickListener {
            showFullscreenFeature()
        }
        mBinding.btnTopSpaced64.setOnClickListener {
            showTopSpacedFeature(64.dp)
        }
        mBinding.btnTopSpaced200.setOnClickListener {
            showTopSpacedFeature(200.dp)
        }
        mBinding.btnNoDim.setOnClickListener {
            showNoDimFeature()
        }

        mBinding.btnFullFeaturedFragment.setOnClickListener {
            showFullFeaturedBottomSheetFragment()
        }
        mBinding.btnFullscreenFragment.setOnClickListener {
            showFullscreenFeatureFragment()
        }
        mBinding.btnTopSpaced64Fragment.setOnClickListener {
            showTopSpacedFeatureFragment(64.dp)
        }
        mBinding.btnTopSpaced200Fragment.setOnClickListener {
            showTopSpacedFeatureFragment(200.dp)
        }
        mBinding.btnNoDimFragment.setOnClickListener {
            showNoDimFeatureFragment()
        }

        mBinding.btnPreviewFragment.setOnClickListener {
            gotoPreviewFragmentActivity()
        }
    }

    private fun showFullFeaturedBottomSheetDialog() {
        if (supportFragmentManager.findFragmentByTag(FullFeaturedBottomSheetDialog.TAG) != null) {
            return
        }

        val fullFeaturedBottomSheetDialog = FullFeaturedBottomSheetDialog.newInstance(
            BottomSheetOptions()
                .noDim(false)
                .topRoundCorner()
        )
        fullFeaturedBottomSheetDialog.show(supportFragmentManager, FullFeaturedBottomSheetDialog.TAG)
    }

    private fun BottomSheetOptions.mergeCommonOptions() = apply {
        hideable(mBinding.switchHideable.isChecked)
        cancelable(mBinding.switchCancelable.isChecked)
    }

    private fun showFullscreenFeature() {
        showFullFeaturedBottomSheetPreviewDialog(
            BottomSheetOptions()
                .fullscreen(true)
                .mergeCommonOptions()
        )
    }

    private fun showTopSpacedFeature(px: Int) {
        showFullFeaturedBottomSheetPreviewDialog(
            BottomSheetOptions()
                .topSpacedPixels(px)
                .mergeCommonOptions()
        )
    }

    private fun showNoDimFeature() {
        showFullFeaturedBottomSheetPreviewDialog(
            BottomSheetOptions()
                .noDim(true)
                .mergeCommonOptions()
        )
    }

    private fun showFullFeaturedBottomSheetPreviewDialog(options: BottomSheetOptions) {
        FullFeaturedBottomSheetPreviewDialog.newInstance(options)
            .show(supportFragmentManager, null)
    }

    private fun showFullFeaturedBottomSheetFragment() {
        val fullFeaturedFragment = FullFeaturedBottomSheetPreviewFragment.newInstance()
        fullFeaturedFragment.show(supportFragmentManager, null)
    }

    private fun showFullscreenFeatureFragment() {
        showFullFeaturedBottomSheetPreviewFragment(
            BottomSheetOptions()
                .fullscreen()
                .mergeCommonOptions()
        )
    }

    private fun showTopSpacedFeatureFragment(px: Int) {
        showFullFeaturedBottomSheetPreviewFragment(
            BottomSheetOptions()
                .topSpacedPixels(px)
                .mergeCommonOptions()
        )
    }

    private fun showNoDimFeatureFragment() {
        showFullFeaturedBottomSheetPreviewFragment(
            BottomSheetOptions()
                .noDim()
                .mergeCommonOptions()
        )
    }

    private fun showFullFeaturedBottomSheetPreviewFragment(options: BottomSheetOptions) {
        FullFeaturedBottomSheetPreviewFragment.newInstance(options)
            .show(supportFragmentManager, null)
    }

    private fun gotoPreviewFragmentActivity() {
        startActivity(Intent(this, BottomSheetFragmentActivity::class.java))
    }

    protected val Int.dp: Int get() =
        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), resources.displayMetrics).toInt()

}