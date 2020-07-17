package com.padcx.travelapp.travelapp_testautomation_mmz.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.padcx.travelapp.travelapp_testautomation_mmz.constants.VALUE_TOUR
import com.padcx.travelapp.travelapp_testautomation_mmz.datas.vos.CountryVO
import com.padcx.travelapp.travelapp_testautomation_mmz.delegates.ToursItemDelegate
import com.padcx.travelapp.travelapp_testautomation_mmz.views.BaseViewHolder
import kotlinx.android.synthetic.main.tours_list_item.view.*

/**
 * Created by Myint Myint Zaw on 7/15/2020.
 */
class PopularTourViewHolder(itemView: View, delegate: ToursItemDelegate) : BaseViewHolder<CountryVO>(itemView) {

    init {
        itemView.setOnClickListener {
            mData?.let {countrydata->
                delegate.onTapTourItem(countrydata.name, VALUE_TOUR)
            }

        }
    }

    override fun bindData(data: CountryVO) {
              mData = data
        Glide.with(itemView.context)
            .load(data.photos[0])
            .centerCrop()
            .into(itemView.iv_tourimg)
        itemView.tv_tourlocation.text = data.name
        itemView.tv_rating.text = data.average_rating.toString()

    }
}