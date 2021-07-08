package com.giz.android.views.tab

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.giz.android.views.R

/**
 * Description of the file
 *
 * Created by GizFei on 2021/3/20
 */
class LightSettingsPagerAdapter: PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = if (position == 0) {
            LayoutInflater.from(container.context).inflate(R.layout.layout_color_light_page, container, false)
        } else {
            LayoutInflater.from(container.context).inflate(R.layout.layout_light_effect_page, container, false)
        }
        container.addView(view)

        return view
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        if (`object` is View) {
            container.removeView(`object`)
        }
    }

    override fun getCount(): Int = 2

    override fun getPageTitle(position: Int): CharSequence {
        return if (position == 0) {
            "Color Light"
        } else {
            "Light Effects"
        }
    }
}