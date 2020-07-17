package com.padcx.travelapp.travelapp_testautomation_mmz.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.padcx.travelapp.travelapp_testautomation_mmz.constants.VALUE_COUNTRY
import com.padcx.travelapp.travelapp_testautomation_mmz.datas.vos.CountryVO
import com.padcx.travelapp.travelapp_testautomation_mmz.delegates.ToursItemDelegate
import com.padcx.travelapp.travelapp_testautomation_mmz.views.BaseViewHolder
import kotlinx.android.synthetic.main.country_list_item.view.*

/**
 * Created by Myint Myint Zaw on 7/15/2020.
 */
class CountryViewHolder(itemView: View, delegate: ToursItemDelegate) : BaseViewHolder<CountryVO>(itemView) {

    init {
        itemView.setOnClickListener {
            mData?.let {
                    countriesdata->
                delegate.onTapTourItem(countriesdata.name, VALUE_COUNTRY)
            }

        }
    }

    override fun bindData(data: CountryVO) {
        mData = data
        Glide.with(itemView.context)
            .load(data.photos[0])
            .centerCrop()
            .into(itemView.iv_country)
        itemView.tv_countryname.text = data.name.toString()
        itemView.tv_rating.text = data.average_rating.toString()
    }

}