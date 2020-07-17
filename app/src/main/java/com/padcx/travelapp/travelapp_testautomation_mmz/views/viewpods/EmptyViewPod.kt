package com.padcx.travelapp.travelapp_testautomation_mmz.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.padcx.travelapp.travelapp_testautomation_mmz.R

/**
 * Created by Myint Myint Zaw on 7/15/2020.
 */
class EmptyViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    override fun onFinishInflate() {
        super.onFinishInflate()

    }

    fun setEmptyData(emptyMessage : String, emptyImageUrl: String){
       /* tvEmpty.text = emptyMessage
        ivEmptyImage.setImageResource(R.drawable.notfound)*/
    }


}