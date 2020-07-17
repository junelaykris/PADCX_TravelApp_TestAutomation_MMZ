package com.padcx.travelapp.travelapp_testautomation_mmz.datas.models.impls

import android.util.Log
import androidx.lifecycle.LiveData
import com.padcx.travelapp.travelapp_testautomation_mmz.constants.EM_NO_INTERNET_CONNECTION
import com.padcx.travelapp.travelapp_testautomation_mmz.datas.models.BaseAppModel
import com.padcx.travelapp.travelapp_testautomation_mmz.datas.models.TourModel
import com.padcx.travelapp.travelapp_testautomation_mmz.datas.vos.CountryVO
import com.padcx.travelapp.travelapp_testautomation_mmz.datas.vos.DataVO
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers

/**
 * Created by Myint Myint Zaw on 7/15/2020.
 */
object TourModelImpl : BaseAppModel(), TourModel {

    override fun getCommonApi(onError: (message: String) -> Unit): Observable<DataVO> {

        val countryList = mApi.getAllCourntries()
            .map { it.data.toList() }.subscribeOn(Schedulers.io())

        val toursList = mApi.getAllTours().map { it.data.toList() }.subscribeOn(Schedulers.io())

        val zipData = Observable.zip(
            countryList,
            toursList,
            createDataVOModel()
        )
        countryList.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mDB.TourDao().insertAllData(it)
            }, {
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })


        toursList.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mDB.TourDao().insertAllData(it)
            }, {
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })


        return zipData
    }

    private fun createDataVOModel(): BiFunction<List<CountryVO>, List<CountryVO>, DataVO> {
        val dataList = ArrayList<CountryVO>()
        val popularList = ArrayList<CountryVO>()
        return BiFunction { one, two ->
            one.forEach {
                dataList.add(it)
            }
            two.forEach {
                popularList.add(it)
            }
            DataVO(dataList, popularList)
        }
    }

    override fun findTourById(name: String): LiveData<CountryVO> {
        return mDB.TourDao().getTourById(name)
    }
}