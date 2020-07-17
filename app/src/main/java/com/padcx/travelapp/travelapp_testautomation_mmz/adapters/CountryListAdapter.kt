package com.padcx.travelapp.travelapp_testautomation_mmz.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcx.travelapp.travelapp_testautomation_mmz.R
import com.padcx.travelapp.travelapp_testautomation_mmz.datas.vos.CountryVO
import com.padcx.travelapp.travelapp_testautomation_mmz.delegates.ToursItemDelegate
import com.padcx.travelapp.travelapp_testautomation_mmz.views.BaseViewHolder
import com.padcx.travelapp.travelapp_testautomation_mmz.views.viewholders.CountryViewHolder

/**
 * Created by Myint Myint Zaw on 7/15/2020.
 */
class CountryListAdapter(delegate: ToursItemDelegate) : BaseRecyclerAdapter<BaseViewHolder<CountryVO>, CountryVO>() {

    val mDelegate = delegate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<CountryVO> {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.country_list_item,parent,false)
        return CountryViewHolder(view,mDelegate)
    }
}