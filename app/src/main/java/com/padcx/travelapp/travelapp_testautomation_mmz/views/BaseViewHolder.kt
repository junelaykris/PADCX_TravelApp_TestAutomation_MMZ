package com.padcx.travelapp.travelapp_testautomation_mmz.views

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Myint Myint Zaw on 7/15/2020.
 */
abstract class BaseViewHolder<W>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    protected var mData: W? = null
    abstract fun bindData(data: W)

}