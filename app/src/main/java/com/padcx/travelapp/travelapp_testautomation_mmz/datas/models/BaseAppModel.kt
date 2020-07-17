package com.padcx.travelapp.travelapp_testautomation_mmz.datas.models

import android.content.Context
import com.padcx.travelapp.travelapp_testautomation_mmz.constants.BASE_URL
import com.padcx.travelapp.travelapp_testautomation_mmz.networks.TourApi
import com.padcx.travelapp.travelapp_testautomation_mmz.persistances.TourDB
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Myint Myint Zaw on 7/15/2020.
 */
abstract class BaseAppModel: BaseModel() {
    var mApi: TourApi
    protected lateinit var mDB: TourDB

    init{
        val mOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(mOkHttpClient)
            .build()

        mApi = retrofit.create(TourApi::class.java)

    }

    fun initDatabase(context: Context){
        mDB = TourDB.getInstance(context)
    }

}