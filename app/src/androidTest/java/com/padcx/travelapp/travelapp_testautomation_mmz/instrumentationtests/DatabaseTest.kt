package com.padcx.travelapp.travelapp_testautomation_mmz.instrumentationtests

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.padcx.travelapp.travelapp_testautomation_mmz.datas.vos.CountryVO
import com.padcx.travelapp.travelapp_testautomation_mmz.persistances.TourDB
import com.padcx.travelapp.travelapp_testautomation_mmz.persistances.TourDao
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

/**
 * Created by Myint Myint Zaw on 7/17/2020.
 */
@RunWith(AndroidJUnit4ClassRunner::class)
class DatabaseTest {
    private lateinit var countryDao: TourDao
    private lateinit var db: TourDB

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, TourDB::class.java
        ).build()
        countryDao = db.TourDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun insertIntoDatabaseTest() {
        val country: CountryVO = getDummyCountry()
        countryDao.insertAllData(Arrays.asList(country))

        assert(countryDao.getTourById(country.name).value?.name == country.name)

    }

    companion object {
        fun getDummyCountry(): CountryVO {
            val countryOne = CountryVO()
            countryOne.name = "Myanmar"
            countryOne.description = "There are so many pagodas in our country!"
            countryOne.location = "Southeast Asia"
            countryOne.average_rating = 5.0

            return countryOne

        }

    }
}