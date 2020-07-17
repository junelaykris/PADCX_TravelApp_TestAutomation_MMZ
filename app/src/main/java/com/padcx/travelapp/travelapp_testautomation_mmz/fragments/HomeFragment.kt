package com.padcx.travelapp.travelapp_testautomation_mmz.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.padcx.travelapp.travelapp_testautomation_mmz.R
import com.padcx.travelapp.travelapp_testautomation_mmz.activities.TourDetailActivity
import com.padcx.travelapp.travelapp_testautomation_mmz.adapters.CountryListAdapter
import com.padcx.travelapp.travelapp_testautomation_mmz.adapters.PopularTourListAdapter
import com.padcx.travelapp.travelapp_testautomation_mmz.datas.models.TourModel
import com.padcx.travelapp.travelapp_testautomation_mmz.datas.vos.DataVO
import com.padcx.travelapp.travelapp_testautomation_mmz.delegates.ToursItemDelegate
import com.padcx.travelapp.travelapp_testautomation_mmz.mvp.MainPresenter
import com.padcx.travelapp.travelapp_testautomation_mmz.mvp.impls.MainPresenterImpl
import com.padcx.travelapp.travelapp_testautomation_mmz.mvp.views.MainView
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Myint Myint Zaw on 7/15/2020.
 */
class HomeFragment : Fragment(), ToursItemDelegate, MainView {

    private lateinit var mTourModel: TourModel

    private lateinit var mcountryAdapter: CountryListAdapter

    private lateinit var mtourAdapter: PopularTourListAdapter

    lateinit var rvcountry: RecyclerView
    private lateinit var mPresenter: MainPresenter
    lateinit var rvtours: RecyclerView
    lateinit var swipeRefreshLayout: SwipeRefreshLayout
    val datalist: ArrayList<DataVO> = arrayListOf()

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        setUpPresenter()

        mPresenter.onUiReadyState(this)

        rvcountry = view.findViewById(R.id.rv_country)
        rvtours = view.findViewById(R.id.rv_tours)

        // swipeRefreshLayout = view.findViewById(R.id.swipeRefresh)

        setupRecyclerView()

        return view
    }

    private fun setupRecyclerView() {
        mcountryAdapter = CountryListAdapter(mPresenter)
        val mlinearLayoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvcountry.layoutManager = mlinearLayoutManager
        rvcountry.adapter = mcountryAdapter

        mtourAdapter = PopularTourListAdapter(mPresenter)
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvtours.layoutManager = linearLayoutManager
        rvtours.adapter = mtourAdapter

    }

    private fun setUpPresenter() {
        mPresenter = MainPresenterImpl()
        mPresenter.initPresenter(this)
    }


    override fun displayCountryList(countryList: DataVO) {
        datalist.clear()
        datalist.add(countryList)
        mcountryAdapter.setNewData(countryList.popourTourList)
        mtourAdapter.setNewData(countryList.popourTourList)
    }

    override fun displayEmptyView() {

    }

    override fun enableSwipeRefresh() {
        // swipeRefreshLayout.isRefreshing = true
    }

    override fun disableSwipeRefresh() {
        // swipeRefreshLayout.isRefreshing = false
    }

    override fun navigateToTourDetail(name: String, value: Int) {
        context?.let {
            ActivityCompat.startActivity(
                it,
                TourDetailActivity.newIntent(it, name, id),
                null
            )
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }

    override fun onTapTourItem(name: String, id: Int) {

    }

}