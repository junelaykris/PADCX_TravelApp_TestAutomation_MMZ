package com.padcx.travelapp.travelapp_testautomation_mmz.mvp

import androidx.lifecycle.LifecycleOwner
import com.padcx.travelapp.travelapp_testautomation_mmz.mvp.views.DetailsView

/**
 * Created by Myint Myint Zaw on 7/15/2020.
 */
interface DetailsPresenter : BasePresenter<DetailsView>
{
    fun onSwipeRefresh(lifecycleOwner: LifecycleOwner)
    fun onDetailUiReadyState(name:String,value:Int,lifecycleOwner: LifecycleOwner)
}