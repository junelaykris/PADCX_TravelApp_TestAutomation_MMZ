package com.padcx.travelapp.travelapp_testautomation_mmz.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.padcx.travelapp.travelapp_testautomation_mmz.R

/**
 * Created by Myint Myint Zaw on 7/15/2020.
 */
class PriceFragment: Fragment() {

    companion object {
        fun newInstance() = PriceFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_price, container, false)
        return view
    }
}