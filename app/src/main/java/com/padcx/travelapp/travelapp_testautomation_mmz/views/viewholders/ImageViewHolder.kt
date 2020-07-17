package com.padcx.travelapp.travelapp_testautomation_mmz.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.padcx.travelapp.travelapp_testautomation_mmz.views.BaseViewHolder
import kotlinx.android.synthetic.main.resort_image_item.view.*

class ImageViewHolder(
    itemView: View
) : BaseViewHolder<String>(itemView) {
    init {
    }

    override fun bindData(data: String) {
        Glide.with(itemView.context)
            .load(data)
            .into(itemView.iv_resort)
    }
}