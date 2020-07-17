package com.padcx.travelapp.travelapp_testautomation_mmz.mvp

import androidx.lifecycle.ViewModel
import com.padcx.travelapp.travelapp_testautomation_mmz.mvp.views.BaseView

/**
 * Created by Myint Myint Zaw on 7/15/2020.
 */
abstract class AbstractBasePresenter<T: BaseView> : BasePresenter<T>, ViewModel() {

    protected lateinit var mView : T

    override fun initPresenter(view: T){
        mView = view
    }
}