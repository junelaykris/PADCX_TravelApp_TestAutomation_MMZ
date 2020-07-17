package com.padcx.travelapp.travelapp_testautomation_mmz.mvp.presenter.impls

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.padcx.travelapp.travelapp_testautomation_mmz.datas.models.impls.TourModelImpl
import com.padcx.travelapp.travelapp_testautomation_mmz.datas.vos.CountryVO
import com.padcx.travelapp.travelapp_testautomation_mmz.mvp.impls.DetailsPresenterImpl
import com.padcx.travelapp.travelapp_testautomation_mmz.mvp.views.DetailsView
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.robolectric.annotation.Config

/**
 * Created by Myint Myint Zaw on 7/18/2020.
 */
@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class DetailPresenterImplTest {
    private lateinit var mPresenter : DetailsPresenterImpl

    @RelaxedMockK
    private lateinit var mView: DetailsView

    @MockK(relaxUnitFun = true)
    private lateinit var mModel : TourModelImpl

    @Before
    fun setUpPresenter() {
        MockKAnnotations.init(this)
        mPresenter = DetailsPresenterImpl()
        mPresenter.initPresenter(mView)

        mPresenter.mTourModel = this.mModel
    }

    @Test
    fun onUIReady_callDisplayDetailList_fromDetailActivity() {

        val lifeCycleOwner = Mockito.mock(LifecycleOwner::class.java)
        val lifeCycleRegistry = LifecycleRegistry(lifeCycleOwner)
        lifeCycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        Mockito.`when`(lifeCycleOwner.lifecycle).thenReturn(lifeCycleRegistry)

        val countryone = CountryVO()
        countryone.name="Sea Flower Resort"
        countryone.average_rating=3.0
        countryone.description="Located in Ko Chang"
        countryone.location="Koh Chang Thailand"

        mPresenter.onDetailUiReadyState("Sea Flower Resort",2,lifeCycleOwner)

        verify {
            mView?.displayDetails(countryone)
        }
    }

}