package com.padcx.travelapp.travelapp_testautomation_mmz.mvp.views

import com.padcx.travelapp.travelapp_testautomation_mmz.datas.vos.DataVO

/**
 * Created by Myint Myint Zaw on 7/15/2020.
 */
interface MainView : BaseView{
    fun displayCountryList(countryList: DataVO)
    fun displayEmptyView()
    fun enableSwipeRefresh()
    fun disableSwipeRefresh()
    fun navigateToTourDetail(name:String,value:Int)
}