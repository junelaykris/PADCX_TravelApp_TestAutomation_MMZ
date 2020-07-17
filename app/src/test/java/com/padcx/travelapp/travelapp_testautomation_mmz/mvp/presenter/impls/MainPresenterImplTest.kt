package com.padcx.travelapp.travelapp_testautomation_mmz.mvp.presenter.impls

import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.padcx.travelapp.travelapp_testautomation_mmz.datas.models.TourModel
import com.padcx.travelapp.travelapp_testautomation_mmz.datas.models.impls.TourModelImpl
import com.padcx.travelapp.travelapp_testautomation_mmz.mvp.impls.MainPresenterImpl
import com.padcx.travelapp.travelapp_testautomation_mmz.mvp.views.MainView
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

/**
 * Created by Myint Myint Zaw on 7/18/2020.
 */
@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class MainPresenterImplTest {
    private lateinit var mPresenter: MainPresenterImpl

    @RelaxedMockK
    private lateinit var mView: MainView

    @MockK(relaxUnitFun = true)
    private lateinit var mModel : TourModelImpl

    @Before
    fun setUpPresenter() {
        MockKAnnotations.init(this)

        MockKAnnotations.init(this)
        mPresenter = MainPresenterImpl()
        mPresenter.initPresenter(mView)
        mPresenter.mTourModel = this.mModel
    }

    @Test
    fun onTapTourItem_fromHomeFragment() {
        mPresenter.onTapTourItem("Sea Flower Resort",2)

        verify {
            mView?.navigateToTourDetail("Sea Flower Resort",2)
        }
    }
}