package com.giz.android.bottomsheet.dialog

import android.app.Dialog
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.giz.android.bottomsheet.R
import com.giz.android.bottomsheet.util.BottomSheetOptions
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 * Description of the file
 *
 * Created by GizFei on 2021/7/4
 */
abstract class BaseBottomSheetDialog<VDB: ViewDataBinding> : BottomSheetDialogFragment() {

    protected lateinit var mBinding: VDB

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(requireContext()), getLayoutId(), null, false)
        initView()

        return BottomSheetDialog(requireContext(), theme).apply {
            setContentView(mBinding.root)
            customizeByOptions(this, getOptions())
            customizeDialog(this)
            customizeWrapperView(findBottomSheetWrapperView(this))
            customBehavior(behavior)
        }
    }

    private fun customizeByOptions(dialog: BottomSheetDialog, options: BottomSheetOptions?) {
        options ?: return

        isCancelable = options.cancelable
        dialog.behavior.apply {
            isHideable = options.hideable
            skipCollapsed = options.skipCollapsed
        }

        if (options.topSpacedPixels != 0) {
            makeTopSpaced(dialog, options.topSpacedPixels)
        } else if (options.fullscreen) {
            matchFullscreen(dialog)
        }
    }

    private fun makeTopSpaced(dialog: BottomSheetDialog, spacedPx: Int) {
        val screenHeight = resources.displayMetrics.heightPixels
        val topSpacedHeight = screenHeight - spacedPx

        findBottomSheetWrapperView(dialog)?.layoutParams?.height = topSpacedHeight
        dialog.behavior.apply {
            peekHeight = topSpacedHeight
            isHideable = false
        }
    }

    private fun matchFullscreen(dialog: BottomSheetDialog) {
        findBottomSheetWrapperView(dialog)?.layoutParams?.height = ViewGroup.LayoutParams.MATCH_PARENT
        dialog.behavior.apply {
            skipCollapsed = true
            state = BottomSheetBehavior.STATE_EXPANDED
        }
    }

    override fun getTheme(): Int {
        val defaultTheme = R.style.YFBottomSheet
        val options = getOptions() ?: return defaultTheme

        return when {
            options.noDim && options.topRoundCorner -> R.style.YFBottomSheet_NoDim_TopRoundCorner
            options.noDim -> R.style.YFBottomSheet_NoDim
            options.topRoundCorner -> R.style.YFBottomSheet_TopRoundCorner
            else -> defaultTheme
        }
    }

    protected fun findBottomSheetWrapperView(dialog: BottomSheetDialog): View? {
        return dialog.findViewById(com.google.android.material.R.id.design_bottom_sheet)
    }

    protected val Int.dp: Int get() =
        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), resources.displayMetrics).toInt()

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun initView()

    open fun customizeDialog(dialog: BottomSheetDialog) {}

    open fun customizeWrapperView(wrapperView: View?) {}

    open fun customBehavior(behavior: BottomSheetBehavior<FrameLayout>) {}

    open fun getOptions(): BottomSheetOptions? = null

}