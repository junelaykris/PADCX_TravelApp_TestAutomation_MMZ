package com.padcx.travelapp.travelapp_testautomation_mmz.views.viewholders

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.padcx.travelapp.travelapp_testautomation_mmz.adapters.CountryListAdapter
import com.padcx.travelapp.travelapp_testautomation_mmz.adapters.PopularTourListAdapter
import com.padcx.travelapp.travelapp_testautomation_mmz.datas.vos.CountryVO
import com.padcx.travelapp.travelapp_testautomation_mmz.datas.vos.DataVO
import com.padcx.travelapp.travelapp_testautomation_mmz.delegates.ToursItemDelegate
import com.padcx.travelapp.travelapp_testautomation_mmz.views.BaseViewHolder

/**
 * Created by Myint Myint Zaw on 7/15/2020.
 */
class MainViewHolder(itemView: View, delegate: ToursItemDelegate) : BaseViewHolder<DataVO>(itemView) {

    val mDelegate = delegate
    private val countryList = mutableListOf<CountryVO>()
    private lateinit var mCountryListAdapter: CountryListAdapter
    private lateinit var mPopularTourListAdapter: PopularTourListAdapter
    override fun bindData(data: DataVO) {
        mData = data
        setUpRecycler()
        if(data.countryList.isNotEmpty())
        {
            mCountryListAdapter.setNewData(data.countryList.toMutableList())
            mPopularTourListAdapter.setNewData(data.popourTourList.toMutableList())
        }

    }

    private fun setUpRecycler(){
     /*   mCountryListAdapter = CountryListAdapter(mDelegate)
        mPopularTourListAdapter = PopularTourListAdapter(mDelegate)
        val mManagerOne = LinearLayoutManager(itemView.country_recyclerview.context,
            LinearLayoutManager.HORIZONTAL,false)
        val mManagerTwo = LinearLayoutManager(itemView.popular_recyclerview.context,
            LinearLayoutManager.VERTICAL,false)
        itemView.country_recyclerview.layoutManager = mManagerOne
        itemView.popular_recyclerview.layoutManager = mManagerTwo
        itemView.country_recyclerview.adapter = mCountryListAdapter
        itemView.popular_recyclerview.adapter = mPopularTourListAdapter*/
    }
}