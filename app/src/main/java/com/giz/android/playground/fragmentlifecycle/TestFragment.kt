package com.giz.android.playground.fragmentlifecycle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.giz.android.playground.R

/**
 * Description of the file
 * Created by GizFei on 2021/1/31
 */
class TestFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return layoutInflater.inflate(R.layout.fragment_test, container, false)
    }
}