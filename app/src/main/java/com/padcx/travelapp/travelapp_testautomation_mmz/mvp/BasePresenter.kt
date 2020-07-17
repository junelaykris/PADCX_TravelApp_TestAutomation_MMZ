package com.padcx.travelapp.travelapp_testautomation_mmz.mvp

import com.padcx.travelapp.travelapp_testautomation_mmz.mvp.views.BaseView

/**
 * Created by Myint Myint Zaw on 7/15/2020.
 */
interface BasePresenter<V: BaseView> {
    fun initPresenter(view: V)
}