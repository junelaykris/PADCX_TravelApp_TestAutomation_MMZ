package com.padcx.travelapp.travelapp_testautomation_mmz.persistances

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padcx.travelapp.travelapp_testautomation_mmz.datas.vos.CountryVO


class CoutryListTypeConverters {
    @TypeConverter
    fun toString(dataList:ArrayList<CountryVO>):String{
        return Gson().toJson(dataList)
    }

    @TypeConverter
    fun toCountryList(countryListJsonStr:String):ArrayList<CountryVO>{
        val countryListType = object : TypeToken<ArrayList<CountryVO>>(){}.type
        return Gson().fromJson(countryListJsonStr,countryListType)
    }
}