package com.giz.android.common.ui.common

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.giz.android.common.R
import com.giz.android.common.databinding.PagePhLoginIntroBinding

/**
 * Description of the file
 *
 * Created by GizFei on 2021/7/4
 */
class PHLoginIntroViewPagerAdapter(
    context: Context,
    private val mPageDataList: List<PHLoginIntroPageData>
) : RecyclerView.Adapter<PHLoginIntroViewPagerAdapter.IntroViewHolder>() {

    private val mLayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroViewHolder {
        return IntroViewHolder(mLayoutInflater.inflate(R.layout.page_ph_login_intro, parent, false))
    }

    override fun onBindViewHolder(holder: IntroViewHolder, position: Int) {
        holder.bind(mPageDataList[position])
    }

    override fun getItemCount(): Int = mPageDataList.size

    class IntroViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val mBinding = PagePhLoginIntroBinding.bind(view)

        fun bind(pageData: PHLoginIntroPageData) {
            mBinding.tvTitle.text = pageData.title
            mBinding.ivPicture.setImageResource(pageData.imgId)
        }
    }

}

class PHLoginIntroPageData(val title: String, val imgId: Int) {
    companion object {
        fun generateDefaultData() = listOf(
            PHLoginIntroPageData("Lorem ipsum dummy text Page 1", R.drawable.undraw_book_lover),
            PHLoginIntroPageData("Lorem ipsum dummy text Page 2", R.drawable.undraw_true_friends),
            PHLoginIntroPageData("Lorem ipsum dummy text Page 3", R.drawable.undraw_winners)
        )
    }
}