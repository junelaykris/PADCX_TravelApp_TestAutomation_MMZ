package com.padcx.travelapp.travelapp_testautomation_mmz.mvp.impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padcx.travelapp.travelapp_testautomation_mmz.constants.VALUE_COUNTRY
import com.padcx.travelapp.travelapp_testautomation_mmz.datas.models.impls.TourModelImpl
import com.padcx.travelapp.travelapp_testautomation_mmz.mvp.AbstractBasePresenter
import com.padcx.travelapp.travelapp_testautomation_mmz.mvp.DetailsPresenter
import com.padcx.travelapp.travelapp_testautomation_mmz.mvp.views.DetailsView

/**
 * Created by Myint Myint Zaw on 7/15/2020.
 */
class DetailsPresenterImpl : DetailsPresenter, AbstractBasePresenter<DetailsView>() {
    var mTourModel: TourModelImpl = TourModelImpl
    override fun onSwipeRefresh(lifecycleOwner: LifecycleOwner) {

    }

    override fun onDetailUiReadyState(name: String,value:Int, lifecycleOwner: LifecycleOwner) {
        when(value){
            VALUE_COUNTRY ->{
                mTourModel.findTourById(name).observe(lifecycleOwner, Observer {
                    mView?.displayDetails(it)
                })
            }
        }

    }
}