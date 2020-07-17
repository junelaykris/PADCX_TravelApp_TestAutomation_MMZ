package com.padcx.travelapp.travelapp_testautomation_mmz.mvp.views

import com.padcx.travelapp.travelapp_testautomation_mmz.datas.vos.CountryVO

/**
 * Created by Myint Myint Zaw on 7/15/2020.
 */
interface DetailsView : BaseView {
    fun displayDetails(news: CountryVO)
}