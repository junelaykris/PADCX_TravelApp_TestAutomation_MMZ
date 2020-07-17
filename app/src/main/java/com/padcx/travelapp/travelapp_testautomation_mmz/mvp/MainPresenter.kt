package com.padcx.travelapp.travelapp_testautomation_mmz.mvp

import androidx.lifecycle.LifecycleOwner
import com.padcx.travelapp.travelapp_testautomation_mmz.delegates.ToursItemDelegate
import com.padcx.travelapp.travelapp_testautomation_mmz.mvp.views.MainView

/**
 * Created by Myint Myint Zaw on 7/15/2020.
 */
interface MainPresenter : ToursItemDelegate, BasePresenter<MainView> {
    fun onSwipeRefresh()
    fun onUiReadyState(lifecycleOwner: LifecycleOwner)
}