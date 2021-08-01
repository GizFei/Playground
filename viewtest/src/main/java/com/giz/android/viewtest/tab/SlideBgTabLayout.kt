package com.giz.android.viewtest.tab

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.BlurMaskFilter
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.core.view.forEach
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import androidx.viewpager.widget.ViewPager
import com.giz.android.viewtest.R
import kotlin.math.round

/**
 * 背景是圆角矩形的标签选项卡
 *
 * Created by GizFei on 2021/3/20
 */
class SlideBgTabLayout @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
)  : LinearLayout(context, attrs, defStyleAttr) {

    /* 可滑动圆角矩形背景相关参数 */
    private var mSlideBgLeft: Float = 0f
    private var mSlideBgRight: Float = 0f
    private val mSlideBgRect = RectF()
    private var mSlideBgBlurRadius: Float = 16f
    private var mAnimatorDuration: Long = 300L
    private var mSlideBgAnimator: ValueAnimator? = null
    private val mSlideBgPaint = Paint().apply {
        flags = Paint.ANTI_ALIAS_FLAG or Paint.DITHER_FLAG
        style = Paint.Style.FILL
        color = context.getColor(R.color.teal_700)
        maskFilter = BlurMaskFilter(mSlideBgBlurRadius, BlurMaskFilter.Blur.SOLID)
    }

    private val mOnTabSelectListeners = mutableListOf<OnTabSelectedListener>()
    private var mViewPager: ViewPager? = null

    private var mInitialized = false

    init {
        setWillNotDraw(false)
        setLayerType(View.LAYER_TYPE_SOFTWARE, null)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        post {
            mInitialized = true
            if (childCount > 0) {
                val firstChild = getChildAt(0)
                updateSlideBgPosition(firstChild.left.toFloat(), firstChild.right.toFloat())
            }
        }
        forEach { child ->
            child.setOnClickListener {
                val idx = indexOfChild(it)
                if (idx != -1) {
                    selectTab(idx)
                    mViewPager?.currentItem = idx
                    mOnTabSelectListeners.forEach { l -> l.onTabSelected(idx) }
                }
            }
        }
    }

    override fun onDraw(canvas: Canvas) {
        // 绘制滑动背景
        canvas.drawRoundRect(mSlideBgRect, height / 2f, height / 2f, mSlideBgPaint)

        super.onDraw(canvas)
    }

    fun selectTab(pos: Int) {
        if (pos !in 0 until childCount) { return }

        if (mInitialized) {
            selectTabInternal(pos)
        } else {
            post {
                selectTabInternal(pos)
                mInitialized = true
            }
        }
    }

    private fun selectTabInternal(pos: Int) {
        val targetView = getChildAt(pos)
        animateSlideBgToPosition(targetView.left.toFloat(), targetView.right.toFloat())
    }

    fun setupWithViewPager(viewpager: ViewPager?) {
        viewpager ?: return

        mViewPager = viewpager
        viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                Log.d(TAG, "onPageScrolled: position: $position, positionOffset: $positionOffset, " +
                        "positionOffsetPixels: $positionOffsetPixels")
            }

            override fun onPageSelected(position: Int) {
                selectTab(position)
            }
        })
    }

    fun addOnTabSelectedListener(listener: OnTabSelectedListener?) {
        if (listener != null && listener !in mOnTabSelectListeners) {
            mOnTabSelectListeners.add(listener)
        }
    }

    fun removeOnTabSelectedListener(listener: OnTabSelectedListener?) {
        if (listener != null) {
            mOnTabSelectListeners.remove(listener)
        }
    }

    private fun updateSlideBgPosition(left: Float, right: Float) {
        if (left != mSlideBgLeft || right != mSlideBgRight) {
            mSlideBgLeft = left
            mSlideBgRight = right
            mSlideBgRect.set(
                mSlideBgLeft + mSlideBgBlurRadius,
                mSlideBgBlurRadius,
                mSlideBgRight - mSlideBgBlurRadius,
                height - mSlideBgBlurRadius
            )
            postInvalidateOnAnimation()
        }
    }

    private fun animateSlideBgToPosition(targetLeft: Float, targetRight: Float) {
        if (targetRight <= targetLeft) {
            return
        }

        val startLeft = mSlideBgLeft
        val startRight = mSlideBgRight

        val updateListener = ValueAnimator.AnimatorUpdateListener {
            updateSlideBgPosition(
                lerp(startLeft, targetLeft, it.animatedFraction),
                lerp(startRight, targetRight, it.animatedFraction)
            )
        }

        if (mSlideBgAnimator == null) {
            mSlideBgAnimator = ValueAnimator.ofFloat(0f, 1f).apply {
                duration = mAnimatorDuration
                interpolator = FastOutSlowInInterpolator()
            }
        }

        mSlideBgAnimator?.run {
            if (isRunning) {
                cancel()
            }
            removeAllUpdateListeners()
            addUpdateListener(updateListener)
            start()
        }
    }

    private fun lerp(startValue: Float, endValue: Float, fraction: Float) =
            startValue + round((endValue - startValue) * fraction)

    interface OnTabSelectedListener {
        fun onTabSelected(position: Int)
    }

    companion object {
        private const val TAG = "SlideBgTabLayout"
    }
}