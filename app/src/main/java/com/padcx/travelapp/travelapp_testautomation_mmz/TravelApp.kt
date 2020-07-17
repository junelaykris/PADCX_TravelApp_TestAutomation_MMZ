package com.padcx.travelapp.travelapp_testautomation_mmz

import android.app.Application
import com.padcx.travelapp.travelapp_testautomation_mmz.datas.models.impls.TourModelImpl

/**
 * Created by Myint Myint Zaw on 7/15/2020.
 */
class TravelApp : Application() {
    override fun onCreate() {

        super.onCreate()

        //Database initialization
        TourModelImpl.initDatabase(applicationContext)

    }
}
