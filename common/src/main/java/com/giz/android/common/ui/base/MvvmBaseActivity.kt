package com.giz.android.common.ui.base

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * 使用DataBinding的页面基类
 *
 * Created by GizFei on 2021/6/28
 */
abstract class MvvmBaseActivity<VDB: ViewDataBinding> : AppCompatActivity() {

    protected lateinit var mBinding: VDB

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, getLayoutId())
        initDataBinding()
        initView()
    }

    @LayoutRes
    abstract fun getLayoutId(): Int

    @CallSuper
    open fun initDataBinding() {
        mBinding.lifecycleOwner = this
    }

    abstract fun initView()

}