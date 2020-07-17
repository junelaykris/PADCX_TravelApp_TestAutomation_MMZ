package com.padcx.travelapp.travelapp_testautomation_mmz.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.appbar.AppBarLayout
import com.padcx.travelapp.travelapp_testautomation_mmz.R
import com.padcx.travelapp.travelapp_testautomation_mmz.adapters.ImageAdpater
import com.padcx.travelapp.travelapp_testautomation_mmz.datas.vos.CountryVO
import com.padcx.travelapp.travelapp_testautomation_mmz.mvp.DetailsPresenter
import com.padcx.travelapp.travelapp_testautomation_mmz.mvp.impls.DetailsPresenterImpl
import com.padcx.travelapp.travelapp_testautomation_mmz.mvp.views.DetailsView
import kotlinx.android.synthetic.main.resort_detail.*

/**
 * Created by Myint Myint Zaw on 7/16/2020.
 */
class TourDetailActivity : AppCompatActivity(), DetailsView {

    private lateinit var mDetailPresenter: DetailsPresenter
    private lateinit var mImageAdapter: ImageAdpater
    lateinit var rvimages: RecyclerView

    companion object {
        private var mName: String? = ""
        private var mvalue: Int? = 0
        fun newIntent(context: Context, name: String, value: Int): Intent {
            mName = name
            mvalue = value
            return Intent(context, TourDetailActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.resort_detail)
        initPresneter()
        setUpRecycler()
        mDetailPresenter.onDetailUiReadyState(
            mName!!, mvalue!!, this
        )
    }


    private fun setUpRecycler() {
        rvimages = findViewById(R.id.rv_resort_image)
        mImageAdapter = ImageAdpater()
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvimages.layoutManager = linearLayoutManager
        rvimages.adapter = mImageAdapter
    }

    private fun initPresneter() {
        mDetailPresenter = DetailsPresenterImpl()
        mDetailPresenter.initPresenter(this)
    }

    override fun displayDetails(detail: CountryVO) {
        tv_resortname.text = detail.name
        tv_location.text = detail.location

        tv_booking.text = detail.scores_and_reviews[0].name
        tv_ratings.text =
            detail.scores_and_reviews[0].score.toString() + "/" + detail.scores_and_reviews[0].max_score.toString()
        totalreview.text =
            "Based on " + detail.scores_and_reviews[0].total_reviews.toString() + " reviews"

        tv_hotelOut.text = detail.scores_and_reviews[1].name
        tv_hotelOut_rating.text =
            detail.scores_and_reviews[1].score.toString() + "/" + detail.scores_and_reviews[1].max_score.toString()
        hotelOut_reviews.text =
            "Based on " + detail.scores_and_reviews[1].total_reviews.toString() + " reviews"

        tv_content.text = detail.description
        mImageAdapter.setNewData(detail.photos)

        Glide.with(this)
            .load(detail.photos[1])
            .into(iv_collapse)

        rating_bar.rating = detail.average_rating.toFloat()

        tv_rating.text = detail.average_rating.toString()

        setSupportActionBar(toolbar)
        tb_collapsing.isTitleEnabled=false
        supportActionBar?.setDisplayShowTitleEnabled(false)
        appBar.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener {
            var isShow = false
            var scrollRange = -1
            override fun onOffsetChanged(appBarLayout: AppBarLayout, verticalOffset: Int) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.totalScrollRange
                }
                if (scrollRange + verticalOffset == 0) {
                    isShow = true

                    toolbar.title=detail.name
                } else if (isShow) {
                    isShow = false
                    toolbar.title=""
                }
            }
        })

        toolbar.setNavigationOnClickListener {
            onBackPressed()

        }

    }
}