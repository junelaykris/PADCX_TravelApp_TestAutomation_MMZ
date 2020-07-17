package com.padcx.travelapp.travelapp_testautomation_mmz.datas.vos
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.padcx.travelapp.travelapp_testautomation_mmz.persistances.PhotoTypeConverter
import com.padcx.travelapp.travelapp_testautomation_mmz.persistances.ScoreReviewConverter


/**
 * Created by Myint Myint Zaw on 7/15/2020.
 */
@Entity(tableName = "country")
@TypeConverters(ScoreReviewConverter::class, PhotoTypeConverter::class)
class CountryVO(
    @PrimaryKey
    @SerializedName("name") var name: String = "",
    @SerializedName("description") var description: String = "",
    @SerializedName("location") var location: String = "",
    @SerializedName("average_rating") var average_rating: Double = 0.0,

    @SerializedName("scores_and_reviews") var scores_and_reviews: ArrayList<ScoreandReviewVO> = arrayListOf(),
    @SerializedName("photos") var photos: ArrayList<String> = arrayListOf()
) {

}