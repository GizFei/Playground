package com.giz.android.views.dialogfragment

import android.os.Bundle
import android.view.*
import android.view.animation.AnimationUtils
import androidx.fragment.app.DialogFragment
import com.giz.android.views.R
import com.giz.android.views.utils.makeFullscreen

/**
 * Description of the file
 *
 * Created by GizFei on 2021/1/31
 */
class BottomDialogFragment : DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_bottom_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        makeFullscreen()
        view.findViewById<View>(R.id.rootView)
            .startAnimation(AnimationUtils.loadAnimation(context, R.anim.push_out_from_bottom))
    }

}