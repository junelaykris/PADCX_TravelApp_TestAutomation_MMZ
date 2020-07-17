package com.padcx.travelapp.travelapp_testautomation_mmz.networks

import com.padcx.travelapp.travelapp_testautomation_mmz.constants.GET_ALL_COUNTRY
import com.padcx.travelapp.travelapp_testautomation_mmz.constants.GET_ALL_TOUR
import com.padcx.travelapp.travelapp_testautomation_mmz.networks.responses.GetAllTourResponse
import com.padcx.travelapp.travelapp_testautomation_mmz.networks.responses.GetCountryResponse
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by Myint Myint Zaw on 7/15/2020.
 */
interface TourApi {

    @GET(GET_ALL_COUNTRY)
    fun getAllCourntries(): Observable<GetCountryResponse>

    @GET(GET_ALL_TOUR)
    fun getAllTours(): Observable<GetAllTourResponse>
}