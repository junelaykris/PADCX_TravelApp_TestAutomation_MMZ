package com.padcx.travelapp.travelapp_testautomation_mmz.networks.responses

import com.google.gson.annotations.SerializedName
import com.padcx.travelapp.travelapp_testautomation_mmz.constants.CODE_RESPONSE
import com.padcx.travelapp.travelapp_testautomation_mmz.datas.vos.CountryVO


/**
 * Created by Myint Myint Zaw on 7/15/2020.
 */
class GetCountryResponse(
    @SerializedName("code")val code: Int = 0,
    @SerializedName("message")val message: String = "",
    @SerializedName("data")val data: ArrayList<CountryVO> = arrayListOf()
) {
    fun isResponseOk():Boolean{
        return data.isEmpty() && code == CODE_RESPONSE
    }
}