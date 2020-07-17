package com.padcx.travelapp.travelapp_testautomation_mmz.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.padcx.travelapp.travelapp_testautomation_mmz.views.BaseViewHolder

/**
 * Created by Myint Myint Zaw on 7/15/2020.
 */
class PhotoViewHolder(itemView: View) : BaseViewHolder<String>(itemView) {
    override fun bindData(data: String) {
     /*   mData = data

        Glide.with(itemView.context)
            .load(data)
            .centerCrop()
            .into(itemView.photoimage)*/
    }
}