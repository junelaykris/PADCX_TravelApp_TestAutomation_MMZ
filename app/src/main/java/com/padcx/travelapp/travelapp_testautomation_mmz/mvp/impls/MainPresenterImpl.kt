package com.padcx.travelapp.travelapp_testautomation_mmz.mvp.impls

import androidx.lifecycle.LifecycleOwner
import com.padcx.travelapp.travelapp_testautomation_mmz.datas.models.impls.TourModelImpl
import com.padcx.travelapp.travelapp_testautomation_mmz.mvp.AbstractBasePresenter
import com.padcx.travelapp.travelapp_testautomation_mmz.mvp.MainPresenter
import com.padcx.travelapp.travelapp_testautomation_mmz.mvp.views.MainView
import io.reactivex.android.schedulers.AndroidSchedulers

/**
 * Created by Myint Myint Zaw on 7/15/2020.
 */
class MainPresenterImpl : MainPresenter, AbstractBasePresenter<MainView>() {

    var mTourModel = TourModelImpl


    override fun onSwipeRefresh() {
        requestAllCountries()
    }

    override fun onUiReadyState(lifecycleOwner: LifecycleOwner) {
        requestAllCountries()
    }


     override fun onTapTourItem(name: String,value: Int) {
         mView?.navigateToTourDetail(name,value)
     }


    private fun requestAllCountries() {
        mView?.enableSwipeRefresh()
        mTourModel.getCommonApi(onError = {
            mView?.disableSwipeRefresh()
            mView?.displayEmptyView()
        }).observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mView?.enableSwipeRefresh()
                mView?.displayCountryList(it)
                mView?.disableSwipeRefresh()
            })
    }

}