package com.padcx.travelapp.travelapp_testautomation_mmz.datas.models

import androidx.lifecycle.LiveData
import com.padcx.travelapp.travelapp_testautomation_mmz.datas.vos.CountryVO
import com.padcx.travelapp.travelapp_testautomation_mmz.datas.vos.DataVO
import io.reactivex.Observable

/**
 * Created by Myint Myint Zaw on 7/15/2020.
 */
interface TourModel {
    fun getCommonApi(onError: (message: String) -> Unit): Observable<DataVO>
    fun findTourById(name: String): LiveData<CountryVO>
}