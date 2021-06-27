package com.giz.android.views.dialogfragment

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.giz.android.views.R
import com.giz.android.views.utils.fillScreenHeight
import com.giz.android.views.utils.fillScreenWidth
import com.giz.android.views.utils.fullscreen
import com.giz.android.views.utils.matchScreenHeight
import kotlinx.android.synthetic.main.activity_dialog_fragment.*

/**
 * 测试DialogFragment
 * Created by GizFei on 2021/1/31
 */
class DialogFragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_fragment)

        makeFullscreen()
        initView()
    }

    private fun makeFullscreen() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE

        window.statusBarColor = Color.TRANSPARENT

        supportActionBar?.hide()
    }

    private fun initView() {
        ivLogin.setOnClickListener {
            BottomDialogFragment().show(supportFragmentManager, "BottomDialogFragment")
        }

        btnFullscreenDlg.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Title")
                .setMessage("Message")
                .create()
                .fullscreen(Color.WHITE)
                .show()
        }

        btnFillScreenWidthDlg.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Title")
                .setMessage("Message")
                .create()
                .fillScreenWidth()
                .show()
        }

        btnFillScreenHeightDlg.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Title")
                .setMessage("Message")
                .create()
                .fillScreenHeight()
                .show()
        }

        btnFullscreenHeightDlg.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Title")
                .setMessage("Message")
                .create()
                .matchScreenHeight(Color.WHITE)
                .show()
        }
    }

}