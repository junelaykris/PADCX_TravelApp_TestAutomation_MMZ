package com.padcx.travelapp.travelapp_testautomation_mmz.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcx.travelapp.travelapp_testautomation_mmz.R
import com.padcx.travelapp.travelapp_testautomation_mmz.views.BaseViewHolder
import com.padcx.travelapp.travelapp_testautomation_mmz.views.viewholders.ImageViewHolder

class ImageAdpater() :BaseRecyclerAdapter<BaseViewHolder<String>, String>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<String>{
        val view= LayoutInflater.from(parent.context).inflate(R.layout.resort_image_item,parent,false)
        return  ImageViewHolder(view)
    }
}